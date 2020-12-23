package JavaCollections.MainTask;

import java.beans.XMLDecoder;
import java.io.*;

public class test {
//    static void libraryMenu(){
//        System.out.println("Menu");
//    }
//    static MP3Library mp3Library;
//    static {
//        mp3Library=new MP3Library();
//    }
//    public static boolean checkExtension(File file) {
//        String fileName= file.getName();
//        return (fileName.substring(fileName.length()-3)=="mp3");
//    }
    public static void main(String[] args) throws FileNotFoundException {
//        ArrayList<Song> listOfSongs =new ArrayList<>();
//        String file1="D:/Music/01. Прошел через.mp3";
//        String file2="D:/Music/02. Привет, придурок.mp3";
//        String file3="D:/Music/03. Молодой с молодой.mp3";
//        String file4="D:/Music/02. Куда надо смотреть.mp3";
//        String file5="D:/Music/03. На порядок выше.mp3";
//        String file6="D:/Music/04. Фальшивые Эм Си.mp3";
//        String file7="D:/Music/12.  Linkin Park  -  The Catalyst.mp3";
//        String file8="D:/Music/11.  Linkin Park  -  What I've Done.mp3";
//        String file9="D:/Music/10.  Linkin Park  -  Breaking The Habit.mp3";

//        listOfSongs.sort(Comparator.comparing(Song::getArtist).thenComparing(Song::getFileName));
//        System.out.println(listOfSongs);
        MP3Library test = new MP3Library();
//        test.listOfSongs.add(new Song(file1));
//        test.listOfSongs.add(new Song(file2));
//        test.listOfSongs.add(new Song(file3));
//        test.listOfSongs.add(new Song(file4));
//        test.listOfSongs.add(new Song(file5));
//        test.listOfSongs.add(new Song(file6));
//        test.listOfSongs.add(new Song(file7));
//        test.listOfSongs.add(new Song(file8));
//        test.listOfSongs.add(new Song(file9));

        String filePath="D:/Music/MP3Library.xml";
        try{
            XMLDecoder e=new XMLDecoder(
                    new BufferedInputStream(
                            new FileInputStream(filePath)));
            //test.listOfSongs=(ArrayList<Song>) e.readObject();

            //System.out.println("Success!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
//        test.listOfSongs.removeIf(song -> song.getFileName()==null);
//        for(int i=0;i<test.listOfSongs.size();i++){
//            if(test.listOfSongs.get(i).getYear()==null) {
//                //System.out.println("null");
//                System.out.println(test.listOfSongs.get(i).getBitRate());
//                System.out.println(test.listOfSongs.get(i).getYear());
//                System.out.println(i+" - "+test.listOfSongs.get(i).getFileName());
//            };
//        }
        test.splitToDVD("D:/Music/");

//        System.out.println(test.listOfSongs.get(0).getClass());
//        System.out.println(test.listOfSongs.get(1).getClass());
//        System.out.println(test.listOfSongs.get(2).getClass());
//
//
//        test.listOfSongs.sort(new MP3Library.songComparator());
//        test.printAllSongs();







//        Song song=new Song("D:/Music/12.  Linkin Park  -  The Catalyst.mp3");
//        System.out.println(song);
//        String  path="data/serial.xml";
//        File file=new File("D:/Music/01. Прошел через.mp3");
//        System.out.println(file.getName().substring(file.getName().length()-3));
//        System.out.println(checkExtension(file));

//        try (XMLEncoder xmlEncoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(path)))) {
//            xmlEncoder.writeObject(song);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

//        XMLEncoder e = new XMLEncoder(
//                new BufferedOutputStream(
//                        new FileOutputStream(path)));
//        e.writeObject(song);
//        e.close();


//        System.out.println("1 - enter Path to XML file...   2 - D:/Music/MP3Library.xml");
//        Scanner scanner=new Scanner(System.in);
//        int modeSelector=1;
//
//        //System.out.println(modeSelector);
//       for(;;){
//            try{
//                modeSelector=scanner.nextInt();
//
//                if(modeSelector>0&modeSelector<3){
//                    System.out.println(modeSelector);
//
//                    if (modeSelector==1){
//                        mp3Library.loadFromXML();
//                        System.out.println("Success");
//                        libraryMenu();
//                    }
//                    if(modeSelector==2){
//                        //mp3Library.loadFromXML("D:/D:/Music/MP3Library.xml");
//                        System.out.println("Success");
//                        libraryMenu();
//                    }
//                    break;
//                }
//                else System.out.println("Please Enter number: xxx");
//
//           }catch (Exception e){
//                System.out.println("Please Enter number: 1 or 2");
//            }
//        }
//    }
    }
}
