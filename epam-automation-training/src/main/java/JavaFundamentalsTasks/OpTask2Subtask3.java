package JavaFundamentalsTasks;

import java.util.Scanner;

public class OpTask2Subtask3 {
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
        //int[][] arr={{4,-1,-6,0,1},{0,4,-1,-3,-5},{8,3,3,1,0},{4,3,3,5,7},{3,4,5,1,3}};
        int[][] arr=randomArray(n,M);
        System.out.println("Generated Array");
        System.out.println(toString(arr));

        int sum=0;
        boolean flag;
        for(int i=0;i<arr.length;i++){
            flag=false;
            for(int j=0;j<arr[i].length-1;j++){
                if (arr[i][j]>0)flag=true;
                if (flag&arr[i][j+1]<=0)sum+=arr[i][j+1]; else if (flag&arr[i][j+1]>0)break;
            }
        }
        System.out.println("Sum of elements in raws between 1st and 2nd posisitive element: "+sum);
    }
}
