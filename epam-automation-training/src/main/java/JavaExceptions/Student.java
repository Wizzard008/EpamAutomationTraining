package JavaExceptions;

import java.util.*;

public class Student {
    private String nameOfUniversity;
    private Faculties faculty;


    private String name;
    private String surname;

    private int group;
    private Map<Subject, List> mapOfSubjectsMarks = new EnumMap<Subject, List>(Subject.class);
    private Map<Subject, Double> mapOfAverageSubjectsMarks = new EnumMap<Subject, Double>(Subject.class);

    private double averageValue(List<Integer> listOfMarks) throws ExceptionMarkLessZeroOrGreaterTen {
        double summation=0;
        for (int i = 0; i < listOfMarks.size(); i++) {
            if((listOfMarks.get(i)<0)|(listOfMarks.get(i)>10)) throw new ExceptionMarkLessZeroOrGreaterTen("Оценка ниже 0 или выше 10");
            summation+=listOfMarks.get(i);
        }
        return summation/listOfMarks.size();
    }


    public double getStudentAverageMark(){
        double summation=0;

        Collection<List> studentMarks=mapOfSubjectsMarks.values();
        Iterator<List> iterator=studentMarks.iterator();
        while (iterator.hasNext()){
            try {
                summation+=averageValue(iterator.next());
            }catch (ExceptionMarkLessZeroOrGreaterTen e){
                System.out.println("Оценка ниже 0 или выше 10");
            }

        }
        return summation/studentMarks.size();
    }

    public Student(){
        super();
        setNameOfUniversity("SUSU");
        setFaculty(Faculties.Mеханико_математический);
        setGroup(100);
        setName("NoName");
        setSurname("NoSurname");
    }

    public Student(String nameOfUniversity, Faculties faculty, int groupNumber){

        String[][] names = {{"Владимир", "Алесандр", "Михаил", "Максим", "Артем", "Лев",
                "Марк", "Дмитрий", "Иван", "Матвей", "Даниил"}, {"Софья", "Мария",
                "Анна", "Виктория", "Алиса", "Полина", "Ева",
                "Елизавета", "Анастасия", "Александра", "Елена"}};
        String[][] surnames = {{"Иванов", "Васильев", "Петров", "Смирнов", "Михайлов", "Фёдоров",
                "Соколов", "Яковлев", "Попов", "Андреев", "Алексеев", "Александров", "Лебедев",
                "Григорьев", "Степанов"}, {"Иванова", "Васильева", "Петрова", "Смирнова", "Михайлова",
                "Фёдорова", "Соколова", "Яковлева", "Попова", "Андреева", "Алексеева",
                "Александрова", "Лебедева", "Григорьева", "Степанова"}};


        this.faculty = faculty;
        this.nameOfUniversity = nameOfUniversity;
        this.group = groupNumber;


        //Формирование имени студента
        Random random = new Random();
        int gender = random.nextInt(2);
        int name = random.nextInt(names[gender].length);
        int surname = random.nextInt(surnames[gender].length);
        this.name = names[gender][name];
        this.surname = surnames[gender][surname];

        //Формирование списка предметов и оценок
        for (int i = 0; i < 5; i++) {
            int subjectIndex = random.nextInt(8);
            List<Integer> listOfMarks = new ArrayList<>();
            int amountOfMarks = random.nextInt(10);
            for (int j = 0; j < amountOfMarks; j++) {
                listOfMarks.add(random.nextInt(11));
            }
            if (amountOfMarks != 0) this.mapOfSubjectsMarks.put(Subject.values()[subjectIndex], listOfMarks);
        }
    }

    public void calculateAverageMarksForAllSubjects() throws ExceptionAbsenceOfSubjects{
        //Вычисление средних балов по всем предметам
        if(mapOfSubjectsMarks.values().size()==0) throw new ExceptionAbsenceOfSubjects();
        for (Map.Entry<Subject,List> pair: mapOfSubjectsMarks.entrySet()) {
            Subject subject=pair.getKey();
            List listOfMarks=pair.getValue();
            try {
                mapOfAverageSubjectsMarks.put(subject,averageValue(listOfMarks));
            }catch (ExceptionMarkLessZeroOrGreaterTen e){
                System.out.println("Оценка ниже 0 или выше 10");
            }

        }
    }


    @Override
    public String toString() {
        try{
            calculateAverageMarksForAllSubjects();
        }catch (ExceptionAbsenceOfSubjects e){
            System.out.println("Отсутствие предметов у студента (должен быть хотя бы один)");
        }

        return  "\n"+name +" "+ surname +
                ", оценки по предметам" + mapOfSubjectsMarks +
                ", средний бал по всем предметам: "+String.format("%.1f",this.getStudentAverageMark())+
                ", средний бал по каждому предмету" + mapOfAverageSubjectsMarks +
                "";
    }

    public String getNameOfUniversity() {
        return nameOfUniversity;
    }

    public Faculties getFaculty() {
        return faculty;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getGroup() {
        return group;
    }

    public Map<Subject, List> getMapOfSubjectsMarks() {
        return mapOfSubjectsMarks;
    }

    public Map<Subject, Double> getMapOfAverageSubjectsMarks() {
        return mapOfAverageSubjectsMarks;
    }

    public void setNameOfUniversity(String nameOfUniversity) {
        this.nameOfUniversity = nameOfUniversity;
    }

    public void setFaculty(Faculties faculty) {
        this.faculty = faculty;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public void setMapOfSubjectsMarks(Map<Subject, List> mapOfSubjectsMarks) {
        this.mapOfSubjectsMarks = mapOfSubjectsMarks;
    }

    public void setMapOfAverageSubjectsMarks(Map<Subject, Double> mapOfAverageSubjectsMarks) {
        this.mapOfAverageSubjectsMarks = mapOfAverageSubjectsMarks;
    }
}
