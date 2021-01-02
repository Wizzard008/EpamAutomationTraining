package JavaExceptions;

public class ExceptionAbsenceOfSubjects extends Exception{
    public ExceptionAbsenceOfSubjects() {
    }

    public ExceptionAbsenceOfSubjects(String message) {
        super(message);
    }

    public ExceptionAbsenceOfSubjects(String message, Throwable cause) {
        super(message, cause);
    }

    public ExceptionAbsenceOfSubjects(Throwable cause) {
        super(cause);
    }
}
