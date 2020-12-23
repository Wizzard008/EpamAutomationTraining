package JavaCollections.MainTask;

import java.util.Scanner;

public class ConsoleInterface {
    static MP3Library mp3Library;
    static {
        mp3Library=new MP3Library();
    }
    public static void main(String[] args) {
        mainMenu();
    }
    public static void mainMenu() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Welcome to MP3 Library manager!");
        System.out.println("1 - Scan songs from Dir...   2 - Load Library from XML file   0 - Exit" );
        int modeSelector;
        for(;;){
            try{
                modeSelector=scanner.nextInt();
                if(modeSelector>=0&modeSelector<3){
                    if (modeSelector==0)subMenuExit();
                    if (modeSelector==1)subMenuScanDir();
                    if (modeSelector==2)subMenuLoadFromXML();
                    break;
                }
                else System.out.println("Please Enter number from 0 to 2!");

            }catch (Exception e){
                System.out.println("Please Enter number from 0 to 2!");
            }
        }
    }

    public static void subMenuGeneral(){
        mp3Library.getGeneralInfo();
        libraryMenu();
    }
    public static void subMenuFilterBy(){

        System.out.println("Filter by...");
        System.out.println("1 - Filter Artist   2 - Filter Album   3 - Filter Year   4 - Filter by Genre   " +
                "5 - Filter by Length   6 - Level up   0 - Exit");
        int modeSelector;
        for(;;){
            try{
                Scanner scanner=new Scanner(System.in);
                modeSelector=scanner.nextInt();
                if(modeSelector>=0&modeSelector<7){
                    if (modeSelector==0){System.out.println("Good luck!"); System.exit(0);}
                    if (modeSelector==1){mp3Library.filterByArtist();subMenuFilterBy();}
                    if (modeSelector==2){mp3Library.filterByAlbum();subMenuFilterBy();}
                    if (modeSelector==3){mp3Library.filterByYear();subMenuFilterBy();}
                    if (modeSelector==4){mp3Library.filterByGenre();subMenuFilterBy();}
                    if (modeSelector==5){if(mp3Library.filterByLength()) subMenuFilterBy();else libraryMenu();}
                    if (modeSelector==6)libraryMenu();
                    break;
                }
                else System.out.println("Please Enter number: 0 or 6");

            }catch (Exception e){
                System.out.println("Please Enter number: 0 or 6");
            }
        }
    }

    public static void subMenuGetList(){
        System.out.println("Get list...");
        System.out.println("1 - Get list of Artists   2 - Get List of Albums   3 - Get List of Years   " +
                "4 - Get list of Genres   5 - Level up   0 - Exit");
        int modeSelector;
        for(;;){
            try{
                Scanner scanner=new Scanner(System.in);
                modeSelector=scanner.nextInt();
                if(modeSelector>=0&modeSelector<6){
                    if (modeSelector==0){System.out.println("Good luck!"); System.exit(0);}
                    if (modeSelector==1){mp3Library.printListOfArtists();subMenuGetList();}
                    if (modeSelector==2){mp3Library.printListOfAlbums();subMenuGetList();}
                    if (modeSelector==3){mp3Library.printListOfYears();subMenuGetList();}
                    if (modeSelector==4){mp3Library.printListOfGenre();subMenuGetList();}
                    if (modeSelector==5)libraryMenu();
                    break;
                }
                else System.out.println("Please Enter number: 0 or 5");

            }catch (Exception e){
                System.out.println("Please Enter number: 0 or 5");
            }
        }
    }
    public static void subMenuPrint(){
        System.out.println("Printing all songs from Library...");
        mp3Library.printAllSongs();
        libraryMenu();
    }
    public static void subMenuSaveToXml(){
        System.out.println("1 - enter Path to XML file...   2 - D:/Music/MP3Library.xml   3 - Level up   0 - Exit");
        Scanner scanner=new Scanner(System.in);
        int modeSelector;
        for(;;){
            try{
                modeSelector=scanner.nextInt();
                if(modeSelector>=0&modeSelector<4){
                    if (modeSelector==0)subMenuExit();
                    if (modeSelector==1){
                        mp3Library.writeToXML();
                        libraryMenu();
                    }
                    if(modeSelector==2){
                        mp3Library.writeToXML("D:/Music/MP3Library.xml");
                        libraryMenu();

                    }
                    if(modeSelector==3){
                        mainMenu();
                    }
                    break;
                }
                else System.out.println("Please Enter number from 0 to 3!");

            }catch (Exception e){
                System.out.println("Please Enter number from 0 to 3!");
            }
        }
    }
    public static void libraryMenu(){
        System.out.println("1 - General...   2 - Filter by...   3 - Get list...   4 - Print all   " +
                "5 - Save to XML   6 - Split To DVD   7 - Level up   0 - Exit");
        int modeSelector;
        for(;;){
            try{
                Scanner scanner=new Scanner(System.in);
                modeSelector=scanner.nextInt();
                if(modeSelector>=0&modeSelector<8){
                    if (modeSelector==0){System.out.println("Good luck!"); System.exit(0);}
                    if (modeSelector==1)subMenuGeneral();
                    if (modeSelector==2){mp3Library.generateSortedList(); subMenuFilterBy();}
                    if (modeSelector==3)subMenuGetList();
                    if (modeSelector==4)subMenuPrint();
                    if (modeSelector==5)subMenuSaveToXml();
                    if (modeSelector==6)subMenuSplitToDVD();
                    if (modeSelector==7)mainMenu();
                    break;
                }
                else System.out.println("Please Enter number from 0 to 7");

            }catch (Exception e){
                System.out.println("Please Enter number from 0 to 7");
            }
        }
    }
    public static void subMenuScanDir(){
        System.out.println("1 - Specify Dir   2 - D:/Music/   3 - Level up   0 - Exit");
        Scanner scanner=new Scanner(System.in);
        int modeSelector;
        for(;;){
            try{
                modeSelector=scanner.nextInt();
                if(modeSelector>=0&modeSelector<4){
                    if (modeSelector==0)subMenuExit();
                    if (modeSelector==1){
                        mp3Library.scanDir();
                        libraryMenu();
                    }
                    if(modeSelector==2){
                        mp3Library.scanDir("D:/Music");
                        libraryMenu();
                    }
                    if(modeSelector==3){
                        mainMenu();
                    }
                    break;
                }
                else System.out.println("Please Enter number from 0 to 3!");

            }catch (Exception e){
                System.out.println("Please Enter number from 0 to 3!");
            }
        }
    }

    public static void subMenuLoadFromXML(){
        System.out.println("1 - enter Path to XML file...   2 - D:/Music/MP3Library.xml   3 - Level up   0 - Exit");
        Scanner scanner=new Scanner(System.in);
        int modeSelector;
        for(;;){
            try{
                modeSelector=scanner.nextInt();
                if(modeSelector>=0&modeSelector<4){
                    if (modeSelector==0)subMenuExit();
                    if (modeSelector==1){
                        mp3Library.loadFromXML();
                        libraryMenu();
                    }
                    if(modeSelector==2){
                        mp3Library.loadFromXML("D:/Music/MP3Library.xml");
                        libraryMenu();

                    }
                    if(modeSelector==3){
                        mainMenu();
                    }
                break;
                }
                else System.out.println("Please Enter number from 0 to 3!");

            }catch (Exception e){
                System.out.println("Please Enter number from 0 to 3!");
            }
        }
    }
    public static void subMenuSplitToDVD(){
        System.out.println("1 - Specify Folder to Store XML files    2 - Store XML files at D:/Music/   " +
                "3 - Level up   0 - Exit");
        int modeSelector;
        for(;;){
            try{
                Scanner scanner=new Scanner(System.in);
                modeSelector=scanner.nextInt();
                if(modeSelector>=0&modeSelector<4){
                    if (modeSelector==0){System.out.println("Good luck!"); System.exit(0);}
                    if (modeSelector==1){mp3Library.splitToDVD();libraryMenu();}
                    if (modeSelector==2){mp3Library.splitToDVD("D:/Music/");libraryMenu();}
                    if (modeSelector==3)mainMenu();
                    break;
                }
                else System.out.println("Please DVD Enter number from 0 to 3");

            }catch (Exception e){
                System.out.println("Exception Please Enter DVD number from 0 to 3");
            }
        }
    }

    public static void subMenuExit(){
        System.out.println("Good luck!");
        System.exit(0);
    }
}
