package JavaFundamentalsTasks;

import java.util.Scanner;

public class MainTask5 {
    public static void main(String[] args) {
        System.out.println("Please enter number within 1..12");
        Scanner scanner=new Scanner(System.in);
        int N = scanner.nextInt();
        for(;;) {
            if ((N>0)&(N<13)) break;
            else {System.out.println("Number Should be within 1..12! Please enter new number: ");N = scanner.nextInt();}
        }
        String[] month=new String[]{"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
        System.out.println("Month for: "+N+" Equal: "+month[N-1]);

    }
}
