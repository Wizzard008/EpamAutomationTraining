package JavaExceptions;

import java.util.*;

public class Faculty {
    private Faculties faculty;
    private List<Group> listOfGroups=new ArrayList<>();
    private List<SubjectAverageMark> subjectsAverageMarks=new ArrayList<>();
    private List<Integer> listOfGroupsNumbers=new ArrayList<>();

    public List<Integer> getlistOfGroupsNumbers() {
        for(Group group:listOfGroups){
            listOfGroupsNumbers.add(group.getGroupNumber());
        }
        return listOfGroupsNumbers;
    }


    //Формирование групп на факультете
    Faculty(String nameOfUniversity, Faculties faculty, int amountOfGroupsOnCourse){
        this.faculty=faculty;
        assert ((amountOfGroupsOnCourse>0)&(amountOfGroupsOnCourse<10));
        //Предполагаем что на каждом факультете 5 курсов на каждом из которых заданное количество групп
        Queue<Integer> groupNumbers=new LinkedList<>();
        for (int i = 1; i <=5 ; i++) {
            for (int j = 0; j < amountOfGroupsOnCourse; j++) {
                groupNumbers.add(i*100+j*10);
            }
        }
        while (!groupNumbers.isEmpty()){
            listOfGroups.add(new Group(nameOfUniversity,faculty, groupNumbers.poll()));
        }
    }

    private void getAverageMarkForEachSubjectForAllStudentsInEachGroup() throws ExceptionAbsenceOfGroupsAtFaculty {

        //Подсчет средних балов для всех групп на факультете

        Subject subjects[]=Subject.values();

        for (int i = 0; i < subjects.length; i++) {
            this.subjectsAverageMarks.add(new SubjectAverageMark(subjects[i],0,0));
        }
        if(listOfGroups.size()==0) throw new ExceptionAbsenceOfGroupsAtFaculty();
        for (int i = 0; i < listOfGroups.size(); i++) {
//            System.out.println(listOfGroups.get(i).getSubjectsAverageMarks().size());
            for (int j = 0; j < subjects.length; j++) {
                this.subjectsAverageMarks.get(j).addMark(listOfGroups.get(i).getSubjectsAverageMarks().get(j).getAverageValue());
            }
        }
    }

    public List<SubjectAverageMark> getSubjectsAverageMarks() {
        try {
            getAverageMarkForEachSubjectForAllStudentsInEachGroup();
        }catch (ExceptionAbsenceOfGroupsAtFaculty e){
            System.out.println("Отсутствие групп на факультете");
        }
        return subjectsAverageMarks;
    }

    @Override
    public String toString() {
        return "***********************" + "\n"+faculty +"\n"+
                listOfGroups;
    }

    public Faculties getFaculty() {
        return faculty;
    }

    public List<Group> getListOfGroups() {
        return listOfGroups;
    }
}

