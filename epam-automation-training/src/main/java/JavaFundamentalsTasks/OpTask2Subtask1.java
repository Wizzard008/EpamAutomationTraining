package JavaFundamentalsTasks;

import java.util.Scanner;

public class OpTask2Subtask1 {
    static int[][] copyArray(int[][] arr){
        int[][] arrCopy=new int[arr.length][arr[0].length];
        for (int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                arrCopy[i][j] = arr[i][j];
            }
        }
        return arrCopy;
    }
    static void swapRaw(int[][] arr, int r){
        int buff;
        for (int i=0;i<arr[r].length;i++){
            buff=arr[r][i];
            arr[r][i]=arr[r+1][i];
            arr[r+1][i]=buff;
        }
    }
    static void swapColumn(int[][] arr, int c){
        int buff;
        for (int i=0;i<arr.length;i++){
            buff=arr[i][c];
            arr[i][c]=arr[i][c+1];
            arr[i][c+1]=buff;
        }
    }
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
        //int[][] arr={{4,1,6,0,0},{0,4,1,3,5},{8,3,3,1,0},{4,3,3,5,7},{3,4,5,1,3}};
        int[][] arr=randomArray(n,M);
        System.out.println("Generated Array");
        System.out.println(toString(arr));

        System.out.println("Please enter raw/column for sorting elements:");
        int k = scanner.nextInt()-1;
        //Copy generated Array
        int[][]arr2=copyArray(arr);
        //Sort k-raw
        for(int i=0;i<arr[k].length;i++){
            for(int j=0;j<arr[k].length-1;j++){
                if (arr[k][j]>arr[k][j+1])swapColumn(arr,j);
            }
        }
        System.out.println("Sorted "+ (k+1)+"- raw");
        System.out.println(toString(arr));

        System.out.println("Initial Array");
        System.out.println(toString(arr2));
        //Sort k-column
        for(int i=0;i<arr2.length;i++){
            for(int j=0;j<arr2.length-1;j++){
                if (arr2[j][k]>arr2[j+1][k])swapRaw(arr2,j);
            }
        }
        System.out.println("Sorted "+(k+1)+"- column");
        System.out.println(toString(arr2));
    }
}
