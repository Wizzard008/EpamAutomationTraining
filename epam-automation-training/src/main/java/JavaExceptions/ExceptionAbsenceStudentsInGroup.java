package JavaExceptions;

public class ExceptionAbsenceStudentsInGroup extends Exception{
    public ExceptionAbsenceStudentsInGroup() {
    }

    public ExceptionAbsenceStudentsInGroup(String message) {
        super(message);
    }

    public ExceptionAbsenceStudentsInGroup(String message, Throwable cause) {
        super(message, cause);
    }

    public ExceptionAbsenceStudentsInGroup(Throwable cause) {
        super(cause);
    }
}
