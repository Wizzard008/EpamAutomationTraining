package JavaFundamentalsTasks;

public class MainTask4 {
    public static void main(String[] args) {
        int s=0,m=1,e;
        for (int i = 0; i < args.length; i++) {
            e=Integer.parseInt(args[i]);
            s+=e;
            m*=e;
        }
        System.out.println("Multiplication of arguments: "+m);
        System.out.println("Summation of arguments: "+s);
    }
}
