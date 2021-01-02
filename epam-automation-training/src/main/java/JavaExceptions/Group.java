package JavaExceptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Group {
    int groupNumber;
    private List<Student> studentsOfGroup=new ArrayList<>();
    private List<SubjectAverageMark> subjectsAverageMarks=new ArrayList<>();
    private List<String> listOfStudentsNames=new ArrayList<>();

    public List<String> getListOfStudentsNames() {
        for(Student student:studentsOfGroup){
            listOfStudentsNames.add(student.getName()+" "+student.getSurname());
        }
        return listOfStudentsNames;
    }


    Group(String nameOfUniversity, Faculties faculty, int groupNumber){
        this.groupNumber=groupNumber;

        //Формирование списка группы
        Random random=new Random();
        //Предполагаем что в группе учится от 10 до 15 человек
        int amountOfStudents=random.nextInt(5)+10;
        for (int i = 0; i < amountOfStudents; i++) {
            studentsOfGroup.add(new Student(nameOfUniversity, faculty, groupNumber));
        }
    }

    private void getAverageMarkForEachSubjectForAllStudentsInGroup() throws ExceptionAbsenceOfSubjects, ExceptionAbsenceStudentsInGroup {

        //Подсчет средних балов всех студентов в группе
        Subject subjects[]=Subject.values();
        for (int i = 0; i < subjects.length; i++) {
            subjectsAverageMarks.add(new SubjectAverageMark(subjects[i],0,0));
        }
        if(studentsOfGroup.size()==0) throw new ExceptionAbsenceStudentsInGroup();
        for (Student student:studentsOfGroup){
            try{
                student.calculateAverageMarksForAllSubjects();
                for (Map.Entry<Subject,Double> pair: student.getMapOfAverageSubjectsMarks().entrySet()) {
                    Subject subject=pair.getKey();
                    Double averageMark=pair.getValue();
                    //поиск индекса
                    if(averageMark!=0){
                        int indexOfSubject=0;
                        for (int i = 0; i <subjects.length ; i++) {
                            if(subjects[i]==subject)indexOfSubject=i;
                        }
                        subjectsAverageMarks.get(indexOfSubject).addMark(averageMark);
                    }
                }
            }catch (ExceptionAbsenceOfSubjects e){
                System.out.println("Отсутствие предметов у студента (должен быть хотя бы один)");
            }
        }
//        System.out.println(subjectsAverageMarks);
    }

    public List<SubjectAverageMark> getSubjectsAverageMarks() {
        try {
            getAverageMarkForEachSubjectForAllStudentsInGroup();
        }catch (ExceptionAbsenceOfSubjects e){
            System.out.println("Отсутствие предметов у студента (должен быть хотя бы один)");
        }catch (ExceptionAbsenceStudentsInGroup e){
            System.out.println("Отсутствие студентов в группе");
        }
        return subjectsAverageMarks;
    }

    @Override
    public String toString() {

        return "\n"+"============="+"\n"+"Группа: " +groupNumber+
//                "\n"+
//                studentsOfGroup+
                " средний бал:" +getSubjectsAverageMarks()+studentsOfGroup;
    }

    public int getGroupNumber() {
        return groupNumber;
    }



    public List<Student> getStudentsOfGroup() {
        return studentsOfGroup;
    }
}
