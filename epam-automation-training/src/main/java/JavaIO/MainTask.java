package JavaIO;

import javax.sound.midi.Soundbank;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MainTask {
    private static void printInsideFiles(String offset, File dir){

            File[] filesInsideFolder = dir.listFiles();

            List<File> folders=new ArrayList<>();
            List<File> files=new ArrayList<>();

            for (File file : filesInsideFolder) {
                if(file.isDirectory()){
                    folders.add(file);
                }else files.add(file);
            }
            for(File folder:folders){
                System.out.println(offset+"    |-----"+folder.getName());
                if(folders.indexOf(folder)<folders.size()-1) {
                    printInsideFiles(offset + "    |     ", folder);
                }else printInsideFiles(offset + "          ", folder);
            }

            for(File file:files){
                System.out.println(offset+file.getName());
            }
        System.out.println(offset);
    }
    private static void printInformationFromFile(File file){
        int totalLengthOfFilesNames=0;
        String line="";
        List<String> folders=new ArrayList<>();
        List<String> files=new ArrayList<>();


        try(FileReader reader=new FileReader(file);BufferedReader bufferedReader=new BufferedReader(reader)) {

            line=bufferedReader.readLine();
//            folders.add(line);

            while ((line=bufferedReader.readLine())!=null){
             if(line.contains("-----")){
                 line=line.substring(line.indexOf("-")+5);
                 folders.add(line);
                }
             else{
                 line=line.replace('|',' ');
                 line=line.trim();
                 if(line.toCharArray().length!=0) {
                     files.add(line);
                     totalLengthOfFilesNames+=line.length();
                 }
             }
            }
            System.out.println("Количество папок: "+folders.size());
            System.out.println("Количесиво файлов: "+files.size());
            System.out.printf("Среднее количество файлов в папке: %.2f \n",(double)files.size()/folders.size());
            System.out.printf("Средняя длина названия файла: %.2f \n",(double)totalLengthOfFilesNames/files.size());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void printInformation(String path){
        File file=new File(path);

        if((file.isDirectory())&(file.exists())) {
            System.out.println(file.getName());
            printInsideFiles("", file);
        }else {
            if ((file.isFile())&(file.exists())&(path.substring(path.length()-3,path.length()).compareTo("txt")==0)){
                printInformationFromFile(file);
            }
            else System.out.println("Wrong dir/file name");
        }
    }
    public static void main(String[] args) {
        String pathFile=args[0];
        pathFile="D:/Video/parseFile.txt";
        printInformation(pathFile);

//        try(PrintStream stream=new PrintStream("D:/Video/parseFile.txt")) {
//            System.setOut(stream);
//            printInformation(pathFile);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
    }
}
