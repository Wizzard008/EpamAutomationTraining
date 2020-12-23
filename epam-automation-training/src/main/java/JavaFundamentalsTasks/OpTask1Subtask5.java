package JavaFundamentalsTasks;

import java.util.Scanner;

public class OpTask1Subtask5 {
    static int odd(String s){
        int res=0;
        for(int i=0;i<s.length();i++){
            if ((s.charAt(i)=='1')|(s.charAt(i)=='3')|(s.charAt(i)=='5')|(s.charAt(i)=='7')|(s.charAt(i)=='9'))res++;
        }
        return res;
    }
    static int even(String s){
        int res=0;
        for(int i=0;i<s.length();i++){
            if ((s.charAt(i)=='0')|(s.charAt(i)=='2')|(s.charAt(i)=='4')|(s.charAt(i)=='6')|(s.charAt(i)=='8'))res++;
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Please enter amount of elements:");
        int N = scanner.nextInt();
        String[] arr=new String[N];
        int evnN=0;
        int eqN=0;
        for(int i=0;i<N;i++){
            System.out.println("Please enter element #"+(i+1)+":");
            arr[i]=scanner.next();
            if(odd(arr[i])==0)evnN++;
            else if (odd(arr[i])==even(arr[i]))eqN++;
        }
        System.out.println("Amount of elements with Even digits only: "+evnN);
        System.out.println("Amount of elements with Equal amount of Even and Odd digits: "+eqN);
    }
}


