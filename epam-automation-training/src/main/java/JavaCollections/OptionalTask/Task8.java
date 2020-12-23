package JavaCollections.OptionalTask;

import java.io.*;
import java.util.*;

//8. Задан файл с текстом на английском языке.
//   Выделить все различные слова.
//   Слова, отличающиеся только регистром букв, считать одинаковыми.
//   Использовать класс HashSet.

public class Task8 {
    public static void main(String[] args) throws IOException {
        File file=new File("data/song.txt");
        FileInputStream fileInputStream=new FileInputStream(file);
        InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
        String line=bufferedReader.readLine();
        Set<String> wordsFromFile=new HashSet<>();
        StringTokenizer words = null;
        while(line!=null){
            if(line!=null) words=new StringTokenizer(line);
            while (words.hasMoreElements()){
                wordsFromFile.add((words.nextToken().toLowerCase()));
            }
            line= bufferedReader.readLine();
        }
        fileInputStream.close();
        System.out.println(wordsFromFile);
        TreeSet<String> sortedWordsFromFile=new TreeSet<>(wordsFromFile);
        System.out.println(sortedWordsFromFile);
        System.out.println("Total amount of unique words in file: "+sortedWordsFromFile.size());
    }
}
