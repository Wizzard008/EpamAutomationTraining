package JavaFundamentalsTasks;

public class MainTask2 {
    public static void main(String[] args) {
        System.out.println("Arguments printed vice versa");
        for (int i = args.length; i > 0; i--) {
            System.out.print(args[i - 1] + " ");
        }
    }
}
