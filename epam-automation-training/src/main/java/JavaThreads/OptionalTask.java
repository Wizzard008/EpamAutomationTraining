package JavaThreads;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class OptionalTask {
    static class Plain{
        int id;
        public Plain(int id) {this.id = id;}
        @Override
        public String toString() {return "plain#" +id;}
    }
    static class Runway{
        int id;
        @Override
        public String toString() { return "runway#" +id;}

        public Runway(int id) {this.id = id;}

        public void takeOff(BlockingQueue<Plain> plainsReadyToFlight){
            Plain currentPlain;
            while (!plainsReadyToFlight.isEmpty()){
                System.out.println("runway#"+id+" is empty");
                try {
                    currentPlain=plainsReadyToFlight.take();
                    System.out.println(this+" adopt a plane");
                    System.out.println(currentPlain+" on "+this+" start take off");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(currentPlain+" on "+this+" left");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        //Создание очереди из самолетов
        BlockingQueue<Plain> plainsReadyToFlight=new LinkedBlockingQueue<>();
        for (int i = 0; i < 10; i++) {
            plainsReadyToFlight.add(new Plain(i+1));
        }
        System.out.println("Plains ready to flight:"+plainsReadyToFlight);
        //Создание взлетных полос и пуск самолетов
        for (int i = 0; i < 5; i++) {
            final int j=i+1;
            new Thread(()->new Runway(j).takeOff(plainsReadyToFlight)).start();
        }
    }
}
