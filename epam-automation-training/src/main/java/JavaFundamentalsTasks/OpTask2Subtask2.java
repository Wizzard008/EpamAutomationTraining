package JavaFundamentalsTasks;

import java.util.Scanner;

public class OpTask2Subtask2 {
    static String toString(int[][] arr){
        String res="";
        for (int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                res+=(arr[i][j]<0?"":" ")+arr[i][j]+" ";
            }
            res+="\n";
        }
        return res;
    }
    static int[][] randomArray(int n, int M){
        int[][] arr = new int[n][n];
        for (int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                //Random elements in range -M..M
                arr[i][j]=(int)(Math.random()*2*M-M);
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Please enter matrix size n:");
        int n = scanner.nextInt();
        System.out.println("Please enter range for array elements M:");
        int M = scanner.nextInt();
        //int[][] arr={{4,1,6,0,0},{0,4,1,3,5},{8,1,3,1,0},{4,3,3,5,7},{1,5,0,4,5}};
        int[][] arr=randomArray(n,M);
        System.out.println("Generated Array");
        System.out.println(toString(arr));

        int max=1;
        int count;
       for(int i=0;i<arr.length;i++){
            count=1;
            for(int j=0;j<arr[i].length-1;j++){
                if (arr[i][j]<arr[i][j+1])count++;else {max=(count>max)?count:max; count=1;}
            }
            max=(count>max)?count:max;
        }

        System.out.println("Maximum amount of continuous growing elements in a raw: "+max);

        max=1;
        for(int j=0;j<arr[0].length;j++){
            count=1;
            for(int i=0;i<arr.length-1;i++){
                if (arr[i][j]<arr[i+1][j])count++;else {max=(count>max)?count:max; count=1;}
            }
            max=(count>max)?count:max;
        }
        System.out.println("Maximum amount of continuous growing elements in a column: "+max);
    }
}
