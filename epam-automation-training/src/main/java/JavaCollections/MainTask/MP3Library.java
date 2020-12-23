package JavaCollections.MainTask;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.*;

public class MP3Library implements LibraryActions {
    private ArrayList<Song> listOfSongs = new ArrayList<>();
    private ArrayList<Song> sortedListOfSongs = new ArrayList<>();
    private ArrayList<String> listOfArtists;
    private ArrayList<String> listOfAlbums;
    private ArrayList<String> listOfYears;
    private ArrayList<String> listOfGenre;
    private ArrayList<Song> dvdSongs;


    @Override
    public void printAllSongs() {
        for (Song listOfSong : listOfSongs) {
            System.out.println(listOfSong);
        }

    }
    public void printAllSongs(List<Song> listOfSongs) {
        for (Song listOfSong : listOfSongs) {
            System.out.println(listOfSong);
        }

    }

    @Override
    public void filterByArtist() {
        getListOfArtists(sortedListOfSongs);
        printListOfArtists();

        System.out.println("Please enter number of Artist:");
        Scanner scanner=new Scanner(System.in);
        for(;;) {
            try {
                int artistNumber = scanner.nextInt();
                if(artistNumber>=0&(artistNumber<listOfArtists.size())){
                    sortedListOfSongs.removeIf(o->o.getArtist().compareTo(listOfArtists.get(artistNumber))!=0);
                    printAllSongs(sortedListOfSongs);

                    break;
                }
                else {
                    System.out.println("Wrong number!");
                }

            } catch (Exception e) {
                System.out.println("Wrong number!");
            }
        }

    }

    @Override
    public void filterByYear() {
        getListOfYears(sortedListOfSongs);
        printListOfYears();

        System.out.println("Please enter number of Year:");
        Scanner scanner=new Scanner(System.in);
        for(;;) {
            try {
                int yearNumber = scanner.nextInt();
                if(yearNumber>=0&(yearNumber<listOfYears.size())){
                    sortedListOfSongs.removeIf(o->o.getYear().compareTo(listOfYears.get(yearNumber))!=0);
                    printAllSongs(sortedListOfSongs);

                    break;
                }
                else {
                    System.out.println("Wrong number!");
                }

            } catch (Exception e) {
                System.out.println("Wrong number!");
            }
        }

    }

    @Override
    public void filterByAlbum() {
        getListOfAlbums(sortedListOfSongs);
        printListOfAlbums();

        System.out.println("Please enter number of Album:");
        Scanner scanner=new Scanner(System.in);
        for(;;) {
            try {
                int albumNumber = scanner.nextInt();
                if(albumNumber>=0&(albumNumber<listOfAlbums.size())){
                    sortedListOfSongs.removeIf(o->o.getAlbum().compareTo(listOfAlbums.get(albumNumber))!=0);
                    printAllSongs(sortedListOfSongs);

                    break;
                }
                else {
                    System.out.println("Wrong number!");
                }

            } catch (Exception e) {
                System.out.println("Wrong number!");
            }
        }

    }

    @Override
    public void filterByGenre() {
        getListOfGenre(sortedListOfSongs);
        printListOfGenre();

        System.out.println("Please enter number of Genre:");
        Scanner scanner=new Scanner(System.in);
        for(;;) {
            try {
                int genreNumber = scanner.nextInt();
                if(genreNumber>=0&(genreNumber<listOfGenre.size())){
                    sortedListOfSongs.removeIf(o->o.getGenre().compareTo(listOfGenre.get(genreNumber))!=0);
                    printAllSongs(sortedListOfSongs);

                    break;
                }
                else {
                    System.out.println("Wrong number!");
                }

            } catch (Exception e) {
                System.out.println("Wrong number!");
            }
        }

    }

    @Override
    public boolean filterByLength() {
        Scanner scanner=new Scanner(System.in);
        for(;;) {
            try {
                System.out.println("Please enter Minimal required length in seconds:");
                int minimalLength = scanner.nextInt();
                System.out.println("Please enter Maximal required length in seconds:");
                int maximalLength = scanner.nextInt();


                if(minimalLength>=0&maximalLength>=0){
                    sortedListOfSongs.removeIf(o->(o.getPlayingTime()<minimalLength)|(o.getPlayingTime()>maximalLength));
                    printAllSongs(sortedListOfSongs);

                    break;
                }
                else {
                    System.out.println("Wrong input data!");
                }

            } catch (Exception e) {
                System.out.println("Wrong input data!");
            }
        }
        if(sortedListOfSongs.size()==0) System.out.println("No Songs match to Length criteria");
        return sortedListOfSongs.size()!=0;
    }

    @Override
    public void getLists() {
        getListOfArtists();
        getListOfAlbums();
        getListOfYears();
        getListOfGenre();
    }

    @Override
    public void generateSortedList() {
        sortedListOfSongs=new ArrayList<>(listOfSongs);
    }

    @Override
    public void getGeneralInfo() {
        System.out.println("Library General Information:");
        System.out.println("Number of songs: "+listOfSongs.size());
        getLists();
        System.out.println("Number of Years present: "+listOfYears.size());
        System.out.println("Number of Genres present: "+listOfGenre.size());
        System.out.println("Number of Albums present: "+listOfAlbums.size());
        System.out.println("Number of Artists present: "+listOfAlbums.size());
        System.out.println("Library file size(Mb): "+libraryFilesSize());
        System.out.println("Library total Playing Time(min): "+totalLength());
    }

    public void getListOfArtists(List<Song> listOfSongs) {
        Set<String> SetOfArtists=new HashSet<>();
        for (Song listOfSong : listOfSongs) {
            SetOfArtists.add(listOfSong.getArtist());
        }
        listOfArtists=new ArrayList<>(SetOfArtists);
        listOfArtists.sort((Comparator.naturalOrder()));
    }


    public void getListOfAlbums(List<Song> listOfSongs) {
        Set<String> SetOfAlbums=new HashSet<>();
        for (Song listOfSong : listOfSongs) {
            SetOfAlbums.add(listOfSong.getAlbum());
        }
        listOfAlbums=new ArrayList<>(SetOfAlbums);
        listOfAlbums.sort((Comparator.naturalOrder()));
    }


    public void getListOfYears(List<Song> listOfSongs) {
        Set<String> SetOfYears=new HashSet<>();
        for (Song listOfSong : listOfSongs) {
            SetOfYears.add(listOfSong.getYear());
        }
        listOfYears=new ArrayList<>(SetOfYears);
        listOfYears.sort((Comparator.naturalOrder()));

    }
    public void getListOfGenre(List<Song> listOfSongs) {
        Set<String> SetOfGenres=new HashSet<>();
        for (Song listOfSong : listOfSongs) {
            SetOfGenres.add(listOfSong.getGenre());
        }
        listOfGenre=new ArrayList<>(SetOfGenres);
        listOfGenre.sort((Comparator.naturalOrder()));
    }


    @Override
    public void getListOfArtists() {
        Set<String> SetOfArtists=new HashSet<>();
        for (Song listOfSong : listOfSongs) {
            SetOfArtists.add(listOfSong.getArtist());
        }
        listOfArtists=new ArrayList<>(SetOfArtists);
        listOfArtists.sort((Comparator.naturalOrder()));
    }

    @Override
    public void getListOfAlbums() {
        Set<String> SetOfAlbums=new HashSet<>();
        for (Song listOfSong : listOfSongs) {
            SetOfAlbums.add(listOfSong.getAlbum());
        }
        listOfAlbums=new ArrayList<>(SetOfAlbums);
        listOfAlbums.sort((Comparator.naturalOrder()));
    }

    @Override
    public void getListOfYears() {
        Set<String> SetOfYears=new HashSet<>();
        for (Song listOfSong : listOfSongs) {
            SetOfYears.add(listOfSong.getYear());
        }
        listOfYears=new ArrayList<>(SetOfYears);
        listOfYears.sort((Comparator.naturalOrder()));
    }

    @Override
    public void getListOfGenre() {
        Set<String> SetOfGenres=new HashSet<>();
        for (Song listOfSong : listOfSongs) {
            SetOfGenres.add(listOfSong.getGenre());
        }
        listOfGenre=new ArrayList<>(SetOfGenres);
        listOfGenre.sort((Comparator.naturalOrder()));
    }

    @Override
    public void printListOfArtists() {
        for(int i=0;i<listOfArtists.size();i++){
            System.out.println(i+" - "+listOfArtists.get(i));
        }
    }

    @Override
    public void printListOfAlbums() {
        for(int i=0;i<listOfAlbums.size();i++){
            System.out.println(i+" - "+listOfAlbums.get(i));
        }
    }

    @Override
    public void printListOfYears() {
        for(int i=0;i<listOfYears.size();i++){
            System.out.println(i+" - "+listOfYears.get(i));
        }
    }

    @Override
    public void printListOfGenre() {
        for(int i=0;i<listOfGenre.size();i++){
            System.out.println(i+" - "+listOfGenre.get(i));
        }
    }

    @Override
    public String totalLength() {
        long totalPlayingTime=0;
        for (Song listOfSong : listOfSongs) {
            totalPlayingTime += listOfSong.getPlayingTime();
        }
        int hr = (int) (totalPlayingTime/(60*60));
        int min = (int) ((totalPlayingTime/60)%60);
        int sec = (int) (totalPlayingTime%60);
        return (hr>0)?hr+" hr "+min+" min "+sec+" sec":min + " min "+sec+" sec";
    }

    @Override
    public long libraryFilesSize() {
        long librarySize=0;
        for (Song listOfSong : listOfSongs) {
            librarySize += listOfSong.getFileSize();
        }
        return librarySize/(1024*1024);
    }

    @Override
    public void scanDir(String dirPath) {
        try {
            processFilesFromFolder(new File(dirPath));
            System.out.println("Success!");
        }catch (Exception e){
            e.printStackTrace();
        }
        getLists();
    }

    @Override
    public void scanDir() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Please enter Dir path:");
        String dirPath=scanner.next();
        scanDir(dirPath);
    }

    @Override
    public void processFilesFromFolder(File folder) {
        File[] folderEntries = folder.listFiles();

        if (folderEntries != null) {
            for (File entry : folderEntries)
            {
                if (entry.isDirectory())
                {
                    processFilesFromFolder(entry);
                    continue;
                }

                if (checkExtension(entry)){
                    System.out.println("Processing file " + entry.getName());
                    listOfSongs.add(new Song(entry));
                }
            }
        }
        listOfSongs.removeIf(song -> song.getFileName()==null);
    }

    @Override
    public boolean checkExtension(File file) {
        String fileName= file.getName();
        return (fileName.substring(fileName.length()-3).compareTo("mp3")==0);
    }

    @Override
    public void loadFromXML(String filePath) {
        try{
            XMLDecoder e=new XMLDecoder(
                    new BufferedInputStream(
                            new FileInputStream(filePath)));
            this.listOfSongs=(ArrayList<Song>) e.readObject();
            getLists();
            System.out.println("Success!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void loadFromXML() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Please specify path to XML file:");
        String filePath=scanner.nextLine();
        loadFromXML(filePath);
    }

    @Override
    public void writeToXML() {
        System.out.println("Please enter name for MP3Library file:");
        Scanner scanner=new Scanner(System.in);
        String fileName=scanner.nextLine();
        writeToXML(fileName);
    }
    public void writeToXML(String filePath) {
        try {
            XMLEncoder e  = new XMLEncoder(
                    new BufferedOutputStream(
                            new FileOutputStream(filePath)));
            e.writeObject(listOfSongs);
            e.close();
            System.out.println("Success!");
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("File not found!");
            fileNotFoundException.printStackTrace();
        }
    }
    @Override
    public void dvdWriteToXML(String filePath) {
        try {
            XMLEncoder e  = new XMLEncoder(
                    new BufferedOutputStream(
                            new FileOutputStream(filePath)));
            e.writeObject(dvdSongs);
            e.close();
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("File not found!");
            fileNotFoundException.printStackTrace();
        }
    }
    @Override
    public void splitToDVD() {
        System.out.println("Please enter Path to store DVD disks XML files:");
        Scanner scanner=new Scanner(System.in);
        String dirPath=scanner.nextLine();
        splitToDVD(dirPath);
    }
    public void splitToDVD(String dirPath) {
        System.out.println("Library will be sorted by Genre then by Artist then by Year and split into DVD disks!");
        listOfSongs.sort(Comparator.comparing(Song::getGenre).thenComparing(Song::getArtist).thenComparing(Song::getYear));
        long dvdSize=4_700_000_000L;
        long cumulativeSize=0;
        dvdSongs=new ArrayList<>();
        int n=0;
        for (Song listOfSong : listOfSongs) {
            cumulativeSize += listOfSong.getFileSize();
            if (cumulativeSize > dvdSize) {
                cumulativeSize = listOfSong.getFileSize();
                dvdSongs = new ArrayList<>();
                n++;
                dvdWriteToXML(dirPath + "dvdDisk" + n + ".xml");
            }
            dvdSongs.add(listOfSong);
        }
        if(cumulativeSize>0){
            n++;
            dvdWriteToXML(dirPath+"dvdDisk"+n+".xml");
        }
        System.out.println((n>1)?"Done! Created "+n+" DVD disks!":"Done! Created 1 DVD disk!");
    }
}
