package JavaIO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

//Прочитать текст Java-программы и все слова public в объявлении атрибутов и методов класса заменить на слово private.

public class OptionalTask2 {
    public static void main(String[] args) {
        File javaCode=new File("JavaIO/MainTask.java");
        List<String> linesFromJavaCode=new ArrayList<>();
        try(FileReader reader=new FileReader(javaCode);BufferedReader bufferedReader=new BufferedReader(reader)){
            bufferedReader.lines().forEach(linesFromJavaCode::add);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(FileWriter writer=new FileWriter(javaCode); BufferedWriter bufferedWriter=new BufferedWriter(writer)){
            for (String s:linesFromJavaCode) {
                if(!s.toLowerCase().contains("class")){
                    s=s.replace("public","private");
//                    s=s.replace("private","public");
                }
                bufferedWriter.write(s);
                bufferedWriter.newLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
