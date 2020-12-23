package JavaClassesTasks;

import java.util.Random;

public class Student {
    private int id;
    private String name;
    private String surname;
    private String middleName;
    private int yearBirth;
    private String adress;
    private String phoneNumber;
    private String faculty;
    private int group;
    private int course;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public int getYearBirth() {
        return yearBirth;
    }

    public void setYearBirth(int yearBirth) {
        this.yearBirth = yearBirth;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    Student generate(int id){
        Student student=new Student();
        String[][] names={{"Владимир", "Алесандр","Михаил", "Максим", "Артем", "Лев",
                "Марк", "Дмитрий", "Иван", "Матвей","Даниил"},{"Софья",  "Мария",
                "Анна", "Виктория", "Алиса", "Полина", "Ева",
                "Елизавета", "Анастасия", "Александра", "Елена"}};
        String[][] surnames={{"Иванов","Васильев", "Петров", "Смирнов", "Михайлов", "Фёдоров",
                "Соколов", "Яковлев", "Попов", "Андреев", "Алексеев", "Александров", "Лебедев",
                "Григорьев", "Степанов"},{"Иванова","Васильева", "Петрова", "Смирнова", "Михайлова",
                "Фёдорова", "Соколова", "Яковлева", "Попова", "Андреева", "Алексеева",
                "Александрова", "Лебедева","Григорьева", "Степанова"}};
        String[][] middlenames={{"Владимирович", "Алесандрович","Михайлович", "Максимович", "Артемович", "Львович",
                "Маркович", "Дмитриевич", "Иванович", "Матвеевич","Даниилович"},{"Владимировна", "Алесандровна",
                "Михаиловна", "Максимовна", "Артемовна", "Львовна","Марковна",
                "Дмитриевна", "Ивановна", "Матвеевна","Данииловна"}};
        int initYear=1998;

        String[] streetNames={"Ленина", "Калинина", "Центральная", "Молодежная", "Школьная", "Лесная",
                "Садовая", "Советская", "Новая", "Набережная", "Заречная", "Зеленая"};
        String[] faculties={"Mеханико–математический","Физический","Химический ", "Биологический",
                "Геологический","Исторический", "Филологический", "Экономический","Юридический",
                "Журналистики","Психологии"};
        student.id=id;
        Random random=new Random();
        int gender=random.nextInt(2);
        int name=random.nextInt(names[gender].length);
        int surname=random.nextInt(surnames[gender].length);
        int middlename=random.nextInt(middlenames[gender].length);
        int street=random.nextInt(streetNames.length);
        int house=random.nextInt(200);
        int room=random.nextInt(100);
        int faculty=random.nextInt(faculties.length);
        student.faculty=faculties[faculty];
        student.group=(random.nextInt(5)+1)*100+(random.nextInt(5)+1)*10;
        student.course=student.group/100;
        student.adress=streetNames[street]+" д. "+house+" кв. "+room;
        student.phoneNumber="+7"+" "+random.nextInt(1000)+" "+random.nextInt(10000000);
        student.name=names[gender][name];
        student.surname=surnames[gender][surname];
        student.middleName=middlenames[gender][middlename];
        student.yearBirth=initYear+(int)(random.nextInt(10));
        return student;
    }
    public String toCSV() {
        return   id +
                "," + name +
                "," + middleName+
                "," + surname +
                "," + yearBirth +
                "," + adress +
                "," + phoneNumber +
                "," + faculty +
                "," + group +
                "," + course;
    }

    @Override
    public String toString() {
        return   "id=" + id +
                ", name='" + name + '\'' +
                ", middleName='" + middleName + '\'' +
                ", surname='" + surname + '\'' +

                ", yearBirth=" + yearBirth +
                ", adress='" + adress + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", faculty='" + faculty + '\'' +
                ", group=" + group +
                ", course=" + course +
                '}';
    }
    public Student() {
        this.id = 0;
        this.name = "noname";
        this.surname = "";
        this.middleName = "";
        this.yearBirth = 0;
        this.adress = "";
        this.phoneNumber = "";
        this.faculty = "";
        this.group = 0;
        this.course = 0;
    }
    public Student(int id, String name, String surname, String middleName, int yearBirth, String adress, String phoneNumber, String faculty, int group, int course) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;
        this.yearBirth = yearBirth;
        this.adress = adress;
        this.phoneNumber = phoneNumber;
        this.faculty = faculty;
        this.group = group;
        this.course = course;
    }
}
