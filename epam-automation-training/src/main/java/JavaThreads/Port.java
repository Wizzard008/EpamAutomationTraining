package JavaThreads;

import java.util.Random;
import java.util.concurrent.*;

//Порт.
// Корабли заходят в порт для разгрузки/загрузки контейнеров.
// Число контейнеров, находящихся в текущий момент в порту и на корабле, должно быть неотрицательным и
// не превышающим заданную грузоподъемность судна и вместимость порта.
// В порту работает несколько причалов.
// У одного причала может стоять один корабль.
// Корабль может загружаться у причала, разгружаться или выполнять оба действия.
public class Port {
    public Port(int amountOfContainers) {
        for (int i = 0; i < amountOfContainers; i++) {
            portWarehouseContainers.add(new Container());
        }
    }

    final static int MAXIMUM_CAPACITY = 100_000;//Amount of containers
    final static int AMOUNT_OF_DOCKING_STATIONS = 5;
    static BlockingDeque<Ship> arrivingShips =new LinkedBlockingDeque<>();
    static BlockingQueue<Ship> departingShips =new LinkedBlockingQueue<>();
    static BlockingDeque<Container> portWarehouseContainers=new LinkedBlockingDeque<>(MAXIMUM_CAPACITY);
    public static int currentLoadedWeight(){
        int containersWeight=0;
        for (Container container:portWarehouseContainers) {
            containersWeight+=container.weight;
        }
        return containersWeight;
    }

    @Override
    public String toString() {
        return "Port: load: "+currentLoadedWeight()+" tons, amount of containers: " + portWarehouseContainers.size()+
                ", max capacity: "+MAXIMUM_CAPACITY+" tons.";
    }

    static class DockingStation{
        int id;
        Port port;
        final static int unloadLoadTimeForContainer=3;

        public DockingStation(int id,Port port) {
            this.id=id;
            this.port = port;
        }

        public void operation(){
            Ship currentShip;
            while (!arrivingShips.isEmpty()){
                try {
                    currentShip = arrivingShips.takeFirst();
                    //запускаем обработку корабля
                    processShip(currentShip,portWarehouseContainers);
                    //Ждем завершения всех операций с кораблем
                    do {
                        TimeUnit.MILLISECONDS.sleep(1);
                    } while (!(!currentShip.load & !currentShip.unload));
                    //Переносим корабль в отплывающиие
                    departingShips.add(currentShip);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Docking#"+id+" operation finished. State "+port);
        }
        public void processShip(Ship ship, BlockingDeque<Container> portWarehouseContainers){
            if (ship.unload) new Thread(()->unload(ship, portWarehouseContainers,ship.containers.size())).start();
            try {
                TimeUnit.MILLISECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (ship.load) new Thread(()->load(ship, portWarehouseContainers)).start();
        }
        private synchronized void  unload(Ship ship, BlockingDeque<Container> portWarehouseContainers, int AmountOfContainersForUnload){
            Container processedContainer;
            System.out.println("Docking#"+id+": start unloading ship#"+ship.id+".");
            for (int i = 0; i < AmountOfContainersForUnload; i++) {
                try {
                    processedContainer= ship.containers.takeFirst();
                    portWarehouseContainers.putLast(processedContainer);
                    //Ждем пока контейнер разгрузится
                    TimeUnit.MILLISECONDS.sleep(unloadLoadTimeForContainer);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Docking#"+id+": unloading for ship#"+ship.id+" finished.");
            ship.setUnload(false);
        }
        private synchronized void load(Ship ship, BlockingDeque<Container> portWarehouseContainers){
            Container processedContainer;
            System.out.println("Docking#"+id+" :start loading ship#"+ship.id);
            while (ship.MAXIMAL_LOAD_TONS - ship.getCurrentLoad()  > Container.MAXIMAL_CONTAINER_WEIGHT){
                try{
                    processedContainer = portWarehouseContainers.takeFirst();
                    ship.containers.putLast(processedContainer);
                    //Ждем пока контейнер разгрузится
                    TimeUnit.MILLISECONDS.sleep(unloadLoadTimeForContainer);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            System.out.println("Docking#"+id+": loading for ship#"+ship.id+" finished.");
            ship.setLoad(false);
        }
    }
    static class Ship{
        int id;
        final int MAXIMAL_LOAD_TONS;
        boolean unload;
        boolean load;



        public void setUnload(boolean unload) {this.unload = unload;}
        public void setLoad(boolean load) {this.load = load;}

        BlockingDeque<Container> containers;

        public Ship(int id, boolean load, boolean unload) {
            containers=new LinkedBlockingDeque<>();
            this.id=id;
            this.MAXIMAL_LOAD_TONS = (((int)(Math.random()*10)))*1000;
            this.unload = unload;
            this.load = load;

            if(unload) {
                Container currentContainer = new Container();
                while (Container.MAXIMAL_CONTAINER_WEIGHT < MAXIMAL_LOAD_TONS -getCurrentLoad()) {
                    containers.add(currentContainer);
                    currentContainer = new Container();
                }
            }
        }
        Ship(int id) {
            this(id,new Random().nextBoolean(),new Random().nextBoolean());
        }

        public int getCurrentLoad() {
            int load=0;
            for (Container container:containers) {
                load+=container.weight;
            }
            return load;
        }

        @Override
        public String toString() {
            return "ship#" +id +" load: "+this.getCurrentLoad()+" tons, amount of containers: "+ containers.size()
                    + ", max capacity: "+ MAXIMAL_LOAD_TONS +" tons"
                    +", type of operation: "+(load?"loading":"")+(load&unload?" and ":"")+(unload?"unloading":""+
                    (!load&!unload?"none":""));
        }
    }
    static class Container{
        int weight;
        final static int MAXIMAL_CONTAINER_WEIGHT=10;
        Container(){
            weight=(int)(Math.random()*MAXIMAL_CONTAINER_WEIGHT);
        }
    }

    public static void main(String[] args) {
        Port port=new Port(3000);
        System.out.println(port);
        for (int i = 0; i < 30; i++) {
            arrivingShips.add(new Ship(i+1));
        }
        for (int i = 0; i < AMOUNT_OF_DOCKING_STATIONS; i++) {
            new Thread(new DockingStation(i+1,port)::operation).start();
        }
    }
}
