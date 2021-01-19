package JavaIO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//   Из файла удалить все слова, содержащие от трех до пяти символов,
//   но при этом из каждой строки должно быть удалено только максимальное четное количество таких слов.
public class OptionalTask7 {
    public static void generateFileWithRandomWords(File file){
        try(FileWriter writer=new FileWriter(file); BufferedWriter bufferedWriter=new BufferedWriter(writer)){

            //100 - lines per file
            //10 - words per line
            //1-10 - words length
            String line;
            int wordLength;
            String word;
            for (int i = 0; i < 100; i++) {
                line="";
                for (int j = 0; j < 10; j++) {
                    //генерируем длину слова
                    wordLength=(int)(Math.random()*10)+1;
                    word="";
                    for (int k = 0; k < wordLength; k++) {
                        word+=(char)((int) (Math.random()*57)+65);
                    }
                line+=" "+word;
                }
                bufferedWriter.write(line.trim());
                bufferedWriter.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String parseLine(String line){
        StringTokenizer wordsFromLine=new StringTokenizer(line);
        List <String> wordsWithLengthFromThreeToFiveSymbols=new ArrayList<>();

        while (wordsFromLine.hasMoreElements()){
            String word=wordsFromLine.nextToken();
            if((word.length()>=3)&(word.length()<=5))wordsWithLengthFromThreeToFiveSymbols.add(word);
        }
        line=" "+line;
        int amountOfWordsForRemoval=(wordsWithLengthFromThreeToFiveSymbols.size()%2==0)? wordsWithLengthFromThreeToFiveSymbols.size()
                :wordsWithLengthFromThreeToFiveSymbols.size()-1;
        if(amountOfWordsForRemoval>0){
            for (int i = 0; i < amountOfWordsForRemoval; i++) {
                line=line.replace(" "+wordsWithLengthFromThreeToFiveSymbols.get(i),"");
            }
        }
        return line.trim();
    }

    public static void processingFile(File file){
        File tempFile=new File(file.getParentFile()+File.separator+"temporary.txt");
        try(FileReader reader=new FileReader(file); BufferedReader bufferedReader=new BufferedReader(reader);
        FileWriter writer=new FileWriter(tempFile);
        BufferedWriter bufferedWriter=new BufferedWriter(writer)) {
            String lineForProcessing;
            while((lineForProcessing=bufferedReader.readLine())!=null) {
                bufferedWriter.write(parseLine(lineForProcessing));
                bufferedWriter.newLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try(FileReader reader=new FileReader(tempFile);
            BufferedReader bufferedReader=new BufferedReader(reader);
            FileWriter writer=new FileWriter(file);
            BufferedWriter bufferedWriter=new BufferedWriter(writer)) {
            String lineForProcessing;
            while((lineForProcessing=bufferedReader.readLine())!=null) {
                bufferedWriter.write(lineForProcessing);
                bufferedWriter.newLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        tempFile.delete();
    }

    public static void main(String[] args) {
        //Задаем имя новой папки
        String dirName="JavaIO";
        File dir=new File(dirName);
        //Если папка не существует, то создаем ее
        if(!dir.exists())dir.mkdir();
        String fileName="FileWithRandomWords";
        File fileWithRandomWords=new File(dirName+File.separator+fileName+".txt");
        //Если файл не существует то создаем его
        if(!fileWithRandomWords.exists())generateFileWithRandomWords(fileWithRandomWords);
        //Удаляем из файла необходимые слова
        processingFile(fileWithRandomWords);

    }
}
