package JavaCollections.OptionalTask;

import java.io.*;
import java.util.ArrayList;

//4.   Занести стихотворение в список.
//     Провести сортировку по возрастанию длин строк.

public class Task4 {
    public static void main(String[] args) throws IOException {
        File file=new File("data/song.txt");
        FileInputStream fileInputStream=new FileInputStream(file);
        InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader=new BufferedReader(inputStreamReader);

        ArrayList<String> listOfLines =new ArrayList<>();

        String line=bufferedReader.readLine();
        while(line!=null){
            listOfLines.add(line);
            //System.out.println(line);
            line= bufferedReader.readLine();
        }
        fileInputStream.close();

        listOfLines.sort((o1, o2) -> o1.length()-o2.length());
        for (int i=0;i<listOfLines.size();i++){
            System.out.println(listOfLines.get(i));
        }
    }
}
