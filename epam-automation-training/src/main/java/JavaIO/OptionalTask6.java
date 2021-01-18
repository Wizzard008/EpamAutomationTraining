package JavaIO;

//Файл содержит символы, слова, целые числа и числа с плавающей запятой. Определить все данные,
//тип которых вводится из командной строки.

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class OptionalTask6 {
    public static void parseLine(String line, int typeOfResult){
        StringTokenizer wordsFromLine=new StringTokenizer(line);
        List <Integer> integers=new ArrayList<>();
        List <Double> doubles=new ArrayList<>();
        List <String> lines=new ArrayList<>();
        int integerNumber;
        double doubleNumber;

        while (wordsFromLine.hasMoreElements()){
            String word=wordsFromLine.nextToken();
            try{
                integerNumber=Integer.parseInt(word);
                integers.add(integerNumber);
            }catch (Exception e1){
                try{
                    doubleNumber=Double.parseDouble(word);
                    doubles.add(doubleNumber);
                }catch (Exception e2){
                    lines.add(word);
                }
            }
        }
        switch (typeOfResult) {
            case 0: System.out.println(integers); break;
            case 1: System.out.println(doubles); break;
            case 2: System.out.println(lines); break;
        }
    }
    public static void generateFileWithRandomData(File file){
        try(FileWriter writer=new FileWriter(file); BufferedWriter bufferedWriter=new BufferedWriter(writer)){
            //Data types 0 - Integer 1 - Double 2 - Char
            //100 - lines per file
            //20 - items per line
            String line;
            for (int i = 0; i < 100; i++) {
                line="";
                for (int j = 0; j < 20; j++) {
                    //определяем тип
                    switch ((int) (Math.random()*3)){
                        case 0:line+=" "+Integer.toString((int) (Math.random()*256));break;
                        case 1:line+=" "+(char)((int) (Math.random()*57)+65)+(char)((int) (Math.random()*57)+65)+(char)((int) (Math.random()*57)+65);break;
                        case 2:line+=" "+Double.toString( (double) (int)(Math.random()*25600)/100);break;
                    }

                }
                bufferedWriter.write(line.trim());
                bufferedWriter.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String dirName="JavaIO";
        File dir=new File(dirName);
        if(!dir.exists())dir.mkdir();
        String fileName="FileWithVariousData";
        String lineForProcessing;
        int typeOfResult;
        File fileWithVariousData=new File(dirName+File.separator+fileName+".txt");

        //Выбор типа необходимых данных
        Scanner scanner=new Scanner(System.in);
        System.out.println("Please select correct data type 0 - Integer 1 - Double 2 - String");
        for(;;) {
            try {
                typeOfResult = scanner.nextInt();
                if((typeOfResult>=0)&(typeOfResult<=2))break;
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Please select correct data type 0 - Integer 1 - Double 2 - String");
        }

        //Создание файла со случайными данными
        generateFileWithRandomData(fileWithVariousData);

        //Чтение из файла данных необходимого типа
        try(FileReader reader=new FileReader(fileWithVariousData); BufferedReader bufferedReader=new BufferedReader(reader)){
            while((lineForProcessing=bufferedReader.readLine())!=null) {
                parseLine(lineForProcessing,typeOfResult);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
