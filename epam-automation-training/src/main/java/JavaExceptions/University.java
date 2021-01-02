package JavaExceptions;

import java.util.*;

public class University {
    private String nameOfUniversity="South Ural State University";
    private List<Faculty> faculties=new ArrayList<>();
    private List<SubjectAverageMark> subjectsAverageMarks=new ArrayList<>();
    private List<Faculties> listOfFacultiesNames=new ArrayList<>();

    public List<Faculties> getListOfFacultiesNames() {
        for(Faculty faculty:faculties){
            listOfFacultiesNames.add(faculty.getFaculty());
        }
        return listOfFacultiesNames;
    }

    University(String nameOfUniversity, int amountOfFaculties, int amountOfGroupsOnCourse){
        this.nameOfUniversity=nameOfUniversity;

        //Generate set of Faculties
        Random random=new Random();
        if(amountOfFaculties>0) {
            Set<Faculties> setOfFaculties = new HashSet<>();
            for (; ; ) {
                setOfFaculties.add(Faculties.values()[random.nextInt(11)]);
                if (setOfFaculties.size() >= amountOfFaculties) break;
            }
            Iterator<Faculties> iterator = setOfFaculties.iterator();
            while (iterator.hasNext()) {
                faculties.add(new Faculty(this.nameOfUniversity, iterator.next(), amountOfGroupsOnCourse));
            }
        }
    }
//    for (Student student : students) {
    public double getAverageMarkForUniversity() throws ExceptionAbsenceOfGroupsAtFaculty {
        double summation=0;
        int amountOfStudents=0;
        if(faculties.size()==0) throw new ExceptionAbsenceOfGroupsAtFaculty();
        for(Faculty faculty:faculties){
            for(Group group:faculty.getListOfGroups()){
                for (Student student : group.getStudentsOfGroup()) {
                    summation+=student.getStudentAverageMark();
                    amountOfStudents++;
                }
            }
        }
        System.out.println(amountOfStudents);
        return summation/amountOfStudents;
    }

    private void getAverageMarkForEachSubjectForEachFaculty() throws ExceptionAbsenceOfGroupsAtFaculty {

        //Подсчет средних балов для всех групп на факультете
        Subject subjects[]=Subject.values();
        for (int i = 0; i < subjects.length; i++) {
            this.subjectsAverageMarks.add(new SubjectAverageMark(subjects[i],0,0));
        }
        if(faculties.size()==0) throw new ExceptionAbsenceOfGroupsAtFaculty();
        for (int i = 0; i < faculties.size(); i++) {
            for (int j = 0; j < subjects.length; j++) {
                this.subjectsAverageMarks.get(j).addMark(faculties.get(i).getSubjectsAverageMarks().get(j).getAverageValue());
            }
        }
    }

    public List<SubjectAverageMark> getSubjectsAverageMarks() {
        try {
            getAverageMarkForEachSubjectForEachFaculty();
        }catch (ExceptionAbsenceOfGroupsAtFaculty e){
            System.out.println("Отсутствие факультетов в университете");
        }
        return subjectsAverageMarks;
    }

    @Override
    public String toString() {
        return nameOfUniversity + "\n" +
                faculties;
    }

    public String getNameOfUniversity() {
        return nameOfUniversity;
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }
}

