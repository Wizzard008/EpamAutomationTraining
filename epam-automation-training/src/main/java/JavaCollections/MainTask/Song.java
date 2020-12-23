package JavaCollections.MainTask;

import JavaCollections.MainTask.lib.MP3File;
import java.io.*;

public class Song {
    private String title;
    private String artist;
    private String album;
    private int bitRate;
    private String composer;
    private String fileName;
    private long fileSize;
    private String genre;
    private String originalArtist;
    private long playingTime;
    private String year;

    public Song() {
    }

    public Song(File file) {

            try {
                MP3File mp3File = new MP3File(file);
                this.title = (mp3File.getTitle() == null) ? "empty" : mp3File.getTitle();
                this.artist = (mp3File.getArtist() == null) ? "empty" : mp3File.getArtist();
                this.album = (mp3File.getAlbum() == null) ? "empty" : mp3File.getAlbum();
                this.bitRate = mp3File.getBitRate();
                this.composer = (mp3File.getComposer() == null) ? "empty" : mp3File.getComposer();
                this.fileName = (mp3File.getFileName()==null)?"empty":mp3File.getFileName();
                this.fileSize = mp3File.getFileSize();
                this.genre = (mp3File.getGenre() == null) ? "empty" : mp3File.getGenre();
                this.originalArtist = (mp3File.getOriginalArtist() == null) ? "empty" : mp3File.getOriginalArtist();
                this.playingTime = mp3File.getPlayingTime();
                this.year = (mp3File.getYear() == null) ? "empty" : mp3File.getYear();

            } catch (Exception e) {
                e.printStackTrace();
            }

    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getAlbum() {
        return album;
    }

    public int getBitRate() {
        return bitRate;
    }

    public String getComposer() {
        return composer;
    }

    public String getFileName() {
        return fileName;
    }

    public long getFileSize() {
        return fileSize;
    }

    public String getGenre() {
        return genre;
    }

    public String getOriginalArtist() {
        return originalArtist;
    }

    public long getPlayingTime() {
        return playingTime;
    }

    public String getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Song{" +
                "title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", album='" + album + '\'' +
                ", genre='" + genre + '\'' +
                ", playingTime=" + playingTime +
                ", year='" + year + '\'' +
                '}';
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public void setBitRate(int bitRate) {
        this.bitRate = bitRate;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setOriginalArtist(String originalArtist) {
        this.originalArtist = originalArtist;
    }

    public void setPlayingTime(long playingTime) {
        this.playingTime = playingTime;
    }

    public void setYear(String year) {
        this.year = year;
    }


}
