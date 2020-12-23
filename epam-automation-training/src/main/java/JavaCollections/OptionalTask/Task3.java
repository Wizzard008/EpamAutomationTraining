package JavaCollections.OptionalTask;

import java.io.File;
import java.util.ArrayList;

//3.   Создать список из элементов каталога и его подкаталогов.

public class Task3 {
    static ArrayList<File> listOfFiles;
    static {
        listOfFiles=new ArrayList<>();
    }
    static void processFilesFromFolder(File folder)
    {
        File[] folderEntries = folder.listFiles();
        for (File entry : folderEntries)
        {
            if (entry.isDirectory())
            {
                processFilesFromFolder(entry);
                continue;
            }
            System.out.println(entry.getAbsoluteFile());
            if(entry!=null)listOfFiles.add(entry);
        }
    }
    public static void main(String[] args) {
        File folder=new File("c:/git/EpamAutomationTraining/src/");
        processFilesFromFolder(folder);
        System.out.println(listOfFiles);
    }
}
