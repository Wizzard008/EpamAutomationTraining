package JavaFundamentalsTasks;

import java.util.Scanner;

public class OpTask1Subtask7 {
    static boolean check(String s){
        boolean res=true;
        boolean n0,n1,n2,n3,n4,n5,n6,n7,n8,n9;
        n0=n1=n2=n3=n4=n5=n6=n7=n8=n9=false;
        if (s.length()>1){
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i)=='0') {if(n0){res=false;break;}else n0=true;}else
                if (s.charAt(i)=='1') {if(n1){res=false;break;}else n1=true;}else
                if (s.charAt(i)=='2') {if(n2){res=false;break;}else n2=true;}else
                if (s.charAt(i)=='3') {if(n3){res=false;break;}else n3=true;}else
                if (s.charAt(i)=='4') {if(n4){res=false;break;}else n4=true;}else
                if (s.charAt(i)=='5') {if(n5){res=false;break;}else n5=true;}else
                if (s.charAt(i)=='6') {if(n6){res=false;break;}else n6=true;}else
                if (s.charAt(i)=='7') {if(n7){res=false;break;}else n7=true;}else
                if (s.charAt(i)=='8') {if(n8){res=false;break;}else n8=true;}else
                if (s.charAt(i)=='9') {if(n9){res=false;break;}else n9=true;}
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
            System.out.println("Status: "+check(arr[i]));
        }
        for(int i=0;i<N;i++){
            if (check(arr[i])){
                System.out.println("First number with unique digits: "+arr[i]);
                break;
            }
        }
    }
}


