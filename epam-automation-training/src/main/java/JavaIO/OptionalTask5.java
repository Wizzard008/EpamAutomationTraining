package JavaIO;

import JavaExceptions.Faculties;
import JavaExceptions.Student;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

//В файле, содержащем фамилии студентов и их оценки, записать прописными буквами фамилии тех студентов, которые имеют средний балл более 6.

public class OptionalTask5 {
    public static void main(String[] args) {
        //Формирование списка сдудентов
        List<Student> students=new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Student student=new Student("SUSU", Faculties.Mеханико_математический,120);
            students.add(student);
        }
        //Запись списка сдудентов в xml файл
        try{ XMLEncoder e  = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("JavaIO/Students.xml")));
            e.writeObject(students);
            e.close();
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }

        //Считывание списка студентов из файла и запись фамилий студентов со средним балом выше 7 в отдельный файл
        try(FileWriter writer=new FileWriter("JavaIO/Students.txt");BufferedWriter bufferedWriter=new BufferedWriter(writer);){
            XMLDecoder e=new XMLDecoder(new BufferedInputStream(new FileInputStream("JavaIO/Students.xml")));

            List<Student> studentsLoadedFromFile=(ArrayList<Student>) e.readObject();
            for (Student student:studentsLoadedFromFile) {

                if(student.getStudentAverageMark()>6){
                    System.out.println(student.getSurname().toUpperCase());
                    bufferedWriter.write(student.getSurname().toUpperCase());
                    bufferedWriter.newLine();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
