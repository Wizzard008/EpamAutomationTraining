package JavaFundamentalsTasks;

import java.util.Scanner;

public class OpTask1Subtask4 {
    static int count(String s){
        int res =(s.contains("0"))?1:0;
        res+=(s.contains("1"))?1:0;
        res+=(s.contains("2"))?1:0;
        res+=(s.contains("3"))?1:0;
        res+=(s.contains("4"))?1:0;
        res+=(s.contains("5"))?1:0;
        res+=(s.contains("6"))?1:0;
        res+=(s.contains("7"))?1:0;
        res+=(s.contains("8"))?1:0;
        res+=(s.contains("9"))?1:0;
        return res;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Please enter amount of elements:");
        int N = scanner.nextInt();
        String[] arr=new String[N];
        int[] n=new int[N];
        for(int i=0;i<N;i++){
            System.out.println("Please enter element #"+(i+1)+":");
            arr[i]=scanner.next();
            n[i]=count(arr[i]);
        }
        int min=n[0];
        for(int i=0;i<N;i++){
            if (n[i]<min) min=n[i];
        }
        for(int i=0;i<N;i++){
            if (n[i]==min) {
                System.out.println("Element with min amount of different digits: "+arr[i]);
                break;
            }
        }
    }
}


