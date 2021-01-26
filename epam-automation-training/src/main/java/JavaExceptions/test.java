package JavaExceptions;

import java.util.*;

public class test {
    public static void main(String[] args) {
//        JavaClassesTasks.Student student=new JavaClassesTasks.Student("ЮУРГУ",Faculties.Экономический,210);
//        System.out.println(student);




        University university=new University("Южно-Уральский Государственный Университет", 0,1);
        System.out.println(university);
        System.out.println(university.getSubjectsAverageMarks());
//        Subject subjects[]=Subject.values();
//        for (int i = 0; i < subjects.length; i++) {
//            System.out.println(subjects[i]);
//        }
//        Double[][]
//        System.out.println(subjects);
        //        Faculty faculty=new Faculty("South Ural State University",Faculties.Биологический,1);
//        System.out.println(faculty);
//        int amountOfGroupsOnCourse=5;
//        Queue<Integer> groupNumbers=new LinkedList<>();
//        for (int i = 1; i <=5 ; i++) {
//            for (int j = 0; j < amountOfGroupsOnCourse; j++) {
//                groupNumbers.add(i*100+j*10);
//            }
//        }
////        System.out.println(groupNumbers);
//        while (!groupNumbers.isEmpty()){
//            System.out.println(groupNumbers.poll());
//        }

//        Faculty faculty=new Faculty("ЮУРГУ",Faculties.Экономический,1);
//        System.out.println(faculty);
//        faculty.getSubjectsAverageMarks();
//        System.out.println(faculty.getSubjectsAverageMarks());
//        Group group=new Group("ЮУРГУ",Faculties.Экономический,100);
//        System.out.println(group.getStudentsOfGroup().size());
//        System.out.println(group.getSubjectsAverageMarks().size());



//        JavaClassesTasks.Student student1=new JavaClassesTasks.Student("South Ural State University",Faculties.Биологический,110);
//        JavaClassesTasks.Student student2=new JavaClassesTasks.Student("South Ural State University",Faculties.Биологический,110);
//        System.out.println(student1.getMapOfAverageSubjectsMarks());
//        System.out.println(student2.getMapOfAverageSubjectsMarks());
//
//        //Подсчет суммы средних балов всех студентов в группе
//        List<SubjectAverageMark> subjectsAverageMarks=new ArrayList<>();
//        Subject subjects[]=Subject.values();
//        for (int i = 0; i < subjects.length; i++) {
//            subjectsAverageMarks.add(new SubjectAverageMark(subjects[i],0,0));
//        }
////        System.out.println(subjectsAverageMarks);
//
//
//
//        for (Map.Entry<Subject,Double> pair: student1.getMapOfAverageSubjectsMarks().entrySet()) {
//            Subject subject=pair.getKey();
//            Double averageMark=pair.getValue();
//            //поиск индекса
//            if(averageMark!=0){
//                int indexOfSubject=0;
//                for (int i = 0; i <subjects.length ; i++) {
//                    if(subjects[i]==subject)indexOfSubject=i;
//                }
//                subjectsAverageMarks.get(indexOfSubject).addMark(averageMark);
//            }
//        }
//
//
//        for (Map.Entry<Subject,Double> pair: student2.getMapOfAverageSubjectsMarks().entrySet()) {
//            Subject subject=pair.getKey();
//            Double averageMark=pair.getValue();
//            //поиск индекса
//            if(averageMark!=0){
//                int indexOfSubject=0;
//                for (int i = 0; i <subjects.length ; i++) {
//                    if(subjects[i]==subject)indexOfSubject=i;
//                }
//                subjectsAverageMarks.get(indexOfSubject).addMark(averageMark);
//            }
//        }
//
//
//
//        System.out.println(subjectsAverageMarks);



//        System.out.println(subjectsAverageMarks);



//        Group group=new Group("South Ural State University",Faculties.Биологический,110);
//        System.out.println(group);


//        int amountOfFaculties=5;
//        assert (amountOfFaculties<=11):"Too many faculties";
//        Random random=new Random();
//        Set<Faculties> setOfFaculties=new HashSet<>();
//        for (;;) {
//            setOfFaculties.add(Faculties.values()[random.nextInt(11)]);
//            if(setOfFaculties.size()>=amountOfFaculties)break;
//        }
//        System.out.println(setOfFaculties);

//        Faculties faculty= Faculties.values()[0];
//        System.out.println(faculty);
//        Group group=new Group(100,5);
//        System.out.println(group);
//
//        StudentsOfUniversity students=new StudentsOfUniversity(3);
//        System.out.println(students);
//        students.getAverageMarksByFacultyByGroup();
//        System.out.println(students);
//        System.out.println(students);
//        System.out.println(students.getAverageMarkForUniversity());
        //students(100);

//        JavaClassesTasks.Student student=new JavaClassesTasks.Student(1);
//        System.out.println(student);
//        System.out.println(student);
//        System.out.println(student.getStudentAverageMark());

    }
}
