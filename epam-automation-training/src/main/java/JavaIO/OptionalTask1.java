package JavaIO;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OptionalTask1 {
    public static void main(String[] args) {
        File  newDir = new File("JavaIO");
        if(!newDir.exists()) {
            newDir.mkdir();
        }
        List<String> linesFromFile= new ArrayList<>();
        File fileWithRandomNumbers=new File(newDir.getAbsolutePath()+"/FileWithRandomNumbers.txt");
        File fileWithSortedNumbers=new File(newDir.getAbsolutePath()+"/FileWithSortedNumbers.txt");
        try {
            fileWithRandomNumbers.createNewFile();
            try(FileWriter writer=new FileWriter(fileWithRandomNumbers)){
                for (int i = 0; i < 100; i++) {
                    writer.write(((int)( Math.random() * 100))+"\n");
                }
            }
            try(FileReader reader=new FileReader(fileWithRandomNumbers);
                BufferedReader bufferedReader=new BufferedReader(reader)){
                bufferedReader.lines().forEach(linesFromFile::add);
                linesFromFile.sort(Comparator.comparingInt(Integer::parseInt));
            }
            fileWithSortedNumbers.createNewFile();
            try (FileWriter writer=new FileWriter(fileWithSortedNumbers)){
                for (String s : linesFromFile) {
                    writer.write(s+"\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
