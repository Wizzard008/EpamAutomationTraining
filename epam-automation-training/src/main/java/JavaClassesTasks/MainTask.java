package JavaClassesTasks;

import java.util.Scanner;

public class MainTask {
    static String[] append(String[] array, String element){
        if(array!=null) {
            String[] temp = new String[array.length + 1];
            for (int i = 0; i < array.length; i++) {
                temp[i] = array[i];
            }
            temp[array.length] = element;
            return temp;
            //System.out.println(temp[students.length].toCSV());
        }
        else return new String[]{element};
    }
    static String[] listOfFaculties(Student[] students){
        String[] temp = new String[0];
        sortByFaculty(students);
        temp=append(temp,students[0].getFaculty());
        int j=0;
        System.out.println(j+1+"-"+temp[j]);
        for(int i=0;i<students.length;i++){
            if(students[i].getFaculty()!=temp[j]){
                temp=append(temp,students[i].getFaculty());
                j++;
                System.out.println(j+1+"-"+temp[j]);
            }
        }
        return temp;
    }
    static Student[] searchForFaculty(Student[] students, String faculty){
        Student[] temp=new Student[0];
        for (int i = 0; i < students.length; i++) {
            if (students[i].getFaculty()==faculty) temp=append(temp,students[i]);
        }
        if(temp.length==0){
            System.out.println("No students in Faculty: "+faculty);
        }
        return temp;
    }
    static Student[] searchForGroup(Student[] students, int group){
        Student[] temp=new Student[0];
        for (int i = 0; i < students.length; i++) {
            if (students[i].getGroup()==group) temp=append(temp,students[i]);
        }
        if(temp.length==0){
            System.out.println("No students in Group: "+group);
        }
        return temp;
    }
    static Student[] append(Student[] students, Student student){
        if(students!=null) {
            Student[] temp = new Student[students.length + 1];
            for (int i = 0; i < students.length; i++) {
                temp[i] = students[i];
            }
            temp[students.length] = student;
            return temp;
            //System.out.println(temp[students.length].toCSV());
        }
        else return new Student[]{student};
    }
    static void sortByName(Student[] students){
        Student temp=new Student();
        for(int i=0; i<students.length;i++){
            for(int j=0; j<students.length;j++){
                if(students[i].getName().compareTo(students[j].getName())>0){
                    temp=students[i];
                    students[i]=students[j];
                    students[j]=temp;
                }
            }
        }
    }
    static void sortByGroup(Student[] students){
        Student temp=new Student();
        for(int i=0; i<students.length;i++){
            for(int j=0; j<students.length;j++){
                if(students[i].getGroup()<students[j].getGroup()){
                    temp=students[i];
                    students[i]=students[j];
                    students[j]=temp;
                }
            }
        }
    }
    static void sortByFaculty(Student[] students){
        Student temp=new Student();
        for(int i=0; i<students.length;i++){
            for(int j=0; j<students.length;j++){
                if(students[i].getFaculty().compareTo(students[j].getFaculty())>0){
                    temp=students[i];
                    students[i]=students[j];
                    students[j]=temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        //Generate list of Students
        Student[] students = new Student[100];
        for(int i=0;i<students.length;i++){
            students[i] = new Student();
            students[i]=students[i].generate(i+1);
            System.out.println(students[i].toCSV());
        }

        //Task - a, search for studens from desired faculty
        //Task -a, started
        String[] faculties= listOfFaculties(students);
        System.out.println("Please select id faculty:");
        int faculty=scanner.nextInt();
        Student[] searchFaculty=searchForFaculty(students,faculties[faculty-1]);
        for(int i=0;i<searchFaculty.length;i++){
            System.out.println(searchFaculty[i].toCSV());
        }
        //Task - a, completed

        //Task - b, least of students for each faculty and course
        //Task -b, started
        //String[] faculties= listOfFaculties(students);
        System.out.println("Please select id faculty:");
        faculty=scanner.nextInt();
        System.out.println("Please enter required course:");
        int course=scanner.nextInt();
        searchFaculty=searchForFaculty(students,faculties[faculty-1]);
        for(int i=0;i<searchFaculty.length;i++){
            if(searchFaculty[i].getCourse()==course){
                System.out.println(searchFaculty[i].toCSV());
            }
        }
        //Task -b, completed


        //Task - c, print list of students born later than year
        //Task -c, started
        System.out.println("Please entre year of birth:");
        int year=scanner.nextInt();
        for(int i=0;i<students.length;i++){
            if (students[i].getYearBirth()>year){
                System.out.println(students[i].toCSV());
            }
        }
        //Task - c, completed

        //Task -d, print list of students in Group
        //Task -d, started
        sortByGroup(students);
        System.out.println("Please enter Group Number:");
        int group=scanner.nextInt();
        students=searchForGroup(students,group);
        for(int i=0;i<students.length;i++){
            System.out.println(students[i].toCSV());
        }
        //Task -d, completed

    }
}
