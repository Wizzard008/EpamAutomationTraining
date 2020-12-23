package JavaFundamentalsTasks;

import java.util.Scanner;

public class OpTask1Subtask3 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Please enter amount of elements:");
        int N = scanner.nextInt();
        String[] arr=new String[N];
        for(int i=0;i<N;i++){
            System.out.println("Please enter element #"+(i+1)+":");
            arr[i]=scanner.next();
        }
        int s=0;
        for(int i=0;i<N;i++){
            s+=arr[i].length();
        }
        float median=s/N;
        System.out.println("Median value: "+median);
        String s1="",s2="";
        for(int i=0;i<N;i++){
           if(arr[i].length()>median) s1+=arr[i]+" ";
           if(arr[i].length()<median) s2+=arr[i]+" ";
        }

        System.out.println("Elements with Length greater than median: "+s1);
        System.out.println("Elements with Length lower than median: "+s2);

    }
}


