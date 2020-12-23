package JavaFundamentalsTasks;

import java.util.Scanner;

public class MainTask3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nPlease enter amount of random elements:");
        int N = scanner.nextInt();
        for(;;) {
            if (N>=0)break;
            else {System.out.println("Wrong Amount of Elements! Please enter new number: ");N = scanner.nextInt();}
        }
        int[] arr = new int[N];
        String s1="",s2="";
        for(int i=0; i<N; i++){
            arr[i]=(int)(Math.random()*N);
            s1+=arr[i]+" ";
            s2+=arr[i]+"\n";
        }
        System.out.println("Elements in one line:");
        System.out.println(s1);
        System.out.println("Elements in one column:");
        System.out.println(s2);
    }
}
