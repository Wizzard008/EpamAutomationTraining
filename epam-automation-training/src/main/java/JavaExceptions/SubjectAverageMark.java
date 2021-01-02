package JavaExceptions;

public class SubjectAverageMark {
    private Subject subject;
    private double summation=0;
    private int amountOfValues=0;
    private double averageValue=0;

    public SubjectAverageMark(Subject subject, double summation, int amountOfValues) {
        this.subject = subject;
        this.summation = summation;
        this.amountOfValues = amountOfValues;
    }
    public void addMark(double averageMark){
        this.summation+=averageMark;
        amountOfValues++;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public double getAverageValue() {
        averageValue=summation/amountOfValues;
        return averageValue;
    }


    @Override
    public String toString() {
        this.averageValue=this.summation/this.amountOfValues;
        return subject +
                " балл " + averageValue;
    }
}
