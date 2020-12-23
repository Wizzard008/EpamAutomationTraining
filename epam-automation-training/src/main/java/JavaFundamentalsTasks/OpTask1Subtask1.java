package JavaFundamentalsTasks;

import java.util.Scanner;

public class OpTask1Subtask1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Please enter amount of elements:");
        int N = scanner.nextInt();
        String[] arr=new String[N];
        for(int i=0;i<N;i++){
            System.out.println("Please enter element #"+(i+1)+":");
            arr[i]=scanner.next();
        }
        int MaxL,MinL;
        MinL=arr[0].length();
        MaxL=arr[0].length();
        String max=arr[0],min=arr[0];
        for(int i=0;i<N;i++){
            if (arr[i].length()>MaxL) {MaxL=arr[i].length(); max=arr[i];}
            else if (arr[i].length()<MinL) {MaxL=arr[i].length(); min=arr[i];}
        }
        System.out.println("Minimal length: "+MinL+" Element: "+min);
        System.out.println("Minimal length: "+MaxL+" Element: "+max);
    }
}
