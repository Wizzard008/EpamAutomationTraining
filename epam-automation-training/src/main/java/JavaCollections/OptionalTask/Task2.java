package JavaCollections.OptionalTask;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

//2.   Ввести число, занести его цифры в стек.
//     Вывести число, у которого цифры идут в обратном порядке.

public class Task2 {
    public static void main(String[] args) {
        System.out.println("Please enter number:");
        Scanner scanner=new Scanner(System.in);
        int number=scanner.nextInt();
        String numberString=Integer.toString(number);
        Deque<Character> stack=new ArrayDeque<>();
        for(int i=0;i<numberString.length();i++){
            stack.push(numberString.charAt(i));
        }
        while (!stack.isEmpty()){
            System.out.print(stack.poll());
        }
    }
}
