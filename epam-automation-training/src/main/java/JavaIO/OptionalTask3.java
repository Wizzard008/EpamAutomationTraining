package JavaIO;

import java.io.*;

public class OptionalTask3 {
    public static void main(String[] args) {
        File javaCode=new File("JavaIO/MainTask.java");
        File javaCodeOutput=new File("JavaIO/MainTask_Revert.java");
        if(!javaCodeOutput.exists()) {
            try {
                javaCodeOutput.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String lineForProcessing;
        String processedLine;
        try(FileReader reader=new FileReader(javaCode); BufferedReader bufferedReader=new BufferedReader(reader);
            FileWriter writer=new FileWriter(javaCodeOutput); BufferedWriter bufferedWriter=new BufferedWriter(writer)){
            while((lineForProcessing=bufferedReader.readLine())!=null) {
                processedLine = "";
                for (int i = lineForProcessing.length() - 1; i >= 0; i--) {
                    processedLine += lineForProcessing.charAt(i);
                }
                bufferedWriter.write(processedLine);
                bufferedWriter.newLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}