package JavaCollections.OptionalTask;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

//1.   Ввести строки из файла, записать в список.
//     Вывести строки в файл в обратном порядке.

public class Task1 {
    public static void main(String[] args) throws IOException, FileNotFoundException {

        File file=new File("data/test.txt");
        FileInputStream fileInputStream=new FileInputStream(file);
        InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
        String line=bufferedReader.readLine();
        Deque<String> stack=new ArrayDeque<>();

        while(line!=null){
            stack.push(line);
            System.out.println(line);
            line= bufferedReader.readLine();
        }
        fileInputStream.close();

        file=new File("data/testRevert.txt");
        FileOutputStream fileOutputStream=new FileOutputStream(file);
        OutputStreamWriter outputStreamWriter=new OutputStreamWriter(fileOutputStream);
        BufferedWriter bufferedWriter=new BufferedWriter(outputStreamWriter);

        while (!stack.isEmpty()){
            line=stack.poll();
            bufferedWriter.write(line);
            if(!stack.isEmpty())bufferedWriter.newLine();
            System.out.println(line);
        }
        bufferedWriter.flush();
        fileOutputStream.close();
    }
}