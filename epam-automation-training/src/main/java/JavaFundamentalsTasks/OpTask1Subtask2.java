package JavaFundamentalsTasks;

import java.util.Scanner;

public class OpTask1Subtask2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Please enter amount of elements:");
        int N = scanner.nextInt();
        String[] arr=new String[N];
        for(int i=0;i<N;i++){
            System.out.println("Please enter element #"+(i+1)+":");
            arr[i]=scanner.next();
        }
        String s;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++) {
                if (arr[i].length() > arr[j].length()) {
                    s=arr[i];
                    arr[i]=arr[j];
                    arr[j]=s;
                }
            }
        }
        String s1="",s2="";
        for(int i=0;i<N;i++){
            s1+=arr[i]+" ";
        }
        for(int i= arr.length;i>0;i--){
            s2+=arr[i-1]+" ";
        }
        System.out.println("Downstream: "+s1);
        System.out.println("Upstream: "+s2);

    }
}
