package JavaFundamentalsTasks;

import java.util.Scanner;

public class OpTask2Subtask4 {
    static int[][] deleteColumn(int[][] arr, int k){
        int[][] res;
        if (arr[0].length==1)res=new int[1][1];
        else{
            res=new int[arr.length][arr[0].length-1];
            for(int i=0;i<arr.length;i++){
                for(int j=0;j<arr[0].length;j++){
                    if(j<k)res[i][j]=arr[i][j];
                    else if(j>k)res[i][j-1]=arr[i][j];
                }
            }
        }
        return res;
    }
    static int[][] deleteRow(int[][] arr, int k){
        int[][] res;
        if (arr.length==1)res=new int[1][1];
        else{
            res=new int[arr.length-1][arr[0].length];
            for(int i=0;i<arr.length;i++){
                for(int j=0;j<arr[0].length;j++){
                    if(i<k)res[i][j]=arr[i][j];
                    else if(i>k)res[i-1][j]=arr[i][j];
                }
            }
        }
        return res;
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
    static String toString(boolean[] arr){
        String res="";
        for (int i=0;i<arr.length;i++){
            res+=arr[i]+" ";
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
        //int[][] arr={{4,1,6,0,0},{0,4,1,3,5},{8,3,3,1,0},{4,3,33,5,7},{3,4,5,1,3}};
        int[][] arr=randomArray(n,M);
        System.out.println("Generated Array");
        System.out.println(toString(arr));
        //Search for Maximum
        int max=arr[0][0];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                max=(arr[i][j]>max)?arr[i][j]:max;
            }
        }
        System.out.println("Maximum Vaule: "+max);
        //Search for affected columns and raws
        boolean[] rows = new boolean[arr.length];
        boolean[] cols = new boolean[arr[0].length];

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(max==arr[i][j]){
                    rows[i]=true;
                    cols[j]=true;
                }
            }
        }
        //Deleting of columns
        for(int i=cols.length-1;i>=0;i--){
            if(cols[i])arr=deleteColumn(arr,i);
        }
        //Deleting of rows
        for(int i=rows.length-1;i>=0;i--){
            if(rows[i])arr=deleteRow(arr,i);
        }
        //Print result
        System.out.println(toString(arr));



    }
}
