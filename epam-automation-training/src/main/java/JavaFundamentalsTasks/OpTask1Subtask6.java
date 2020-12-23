package JavaFundamentalsTasks;

import java.util.Scanner;

public class OpTask1Subtask6 {
    static boolean check(String s){
        boolean res=true;
        if (s.length()>1){
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i-1)>s.charAt(i)) {res=false;break;}
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Please enter amount of elements:");
        int N = scanner.nextInt();
        String[] arr=new String[N];

        for(int i=0;i<N;i++){
            System.out.println("Please enter element #"+(i+1)+":");
            arr[i]=scanner.next();
        }
        for(int i=0;i<N;i++){
            if (check(arr[i])){
                System.out.println("First number with digits in growing order: "+arr[i]);
                break;
            }
        }
    }
}


