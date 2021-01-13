package JavaIO;

import java.io.*;
import java.util.StringTokenizer;

//Прочитать текст Java-программы и в каждом слове длиннее двух символов все строчные символы заменить прописными.

public class OptionalTask4 {
    public static void main(String[] args) {
        File javaCodeInput=new File("JavaIO/MainTask.java");
        File javaCodeOutput=new File("JavaIO/MainTask_UpperCase.java");
        if(!javaCodeOutput.exists()) {
            try {
                javaCodeOutput.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String lineForProcessing;

        try(FileReader reader=new FileReader(javaCodeInput); BufferedReader bufferedReader=new BufferedReader(reader);
            FileWriter writer=new FileWriter(javaCodeOutput); BufferedWriter bufferedWriter=new BufferedWriter(writer)){
            while((lineForProcessing=bufferedReader.readLine())!=null) {
                StringTokenizer wordsFromLine=new StringTokenizer(lineForProcessing);
                while (wordsFromLine.hasMoreElements()){
                    String word=wordsFromLine.nextToken();
                    if(word.length()>2) lineForProcessing=lineForProcessing.replace(word,word.toUpperCase());
                }
                bufferedWriter.write(lineForProcessing);
                bufferedWriter.newLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

