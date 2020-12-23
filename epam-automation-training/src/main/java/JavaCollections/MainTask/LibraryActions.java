package JavaCollections.MainTask;

import java.io.File;

public interface LibraryActions {
    void printAllSongs();

    void filterByArtist();
    void filterByYear();
    void filterByAlbum();
    void filterByGenre();
    boolean filterByLength();


    void getLists();
    void generateSortedList();

    void getGeneralInfo();


    void getListOfArtists();
    void getListOfAlbums();
    void getListOfYears();
    void getListOfGenre();

    void printListOfArtists();
    void printListOfAlbums();
    void printListOfYears();
    void printListOfGenre();


    String totalLength();
    long libraryFilesSize();


    void scanDir(String dirPath);
    void scanDir();
    void processFilesFromFolder(File folder);
    boolean checkExtension(File file);

    void loadFromXML(String filePath);
    void loadFromXML();
    void writeToXML();
    void dvdWriteToXML(String filePath);
    void splitToDVD();
}
