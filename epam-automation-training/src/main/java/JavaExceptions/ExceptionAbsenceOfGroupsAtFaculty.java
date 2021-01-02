package JavaExceptions;

public class ExceptionAbsenceOfGroupsAtFaculty extends Exception{
    public ExceptionAbsenceOfGroupsAtFaculty() {
    }

    public ExceptionAbsenceOfGroupsAtFaculty(String message) {
        super(message);
    }

    public ExceptionAbsenceOfGroupsAtFaculty(String message, Throwable cause) {
        super(message, cause);
    }

    public ExceptionAbsenceOfGroupsAtFaculty(Throwable cause) {
        super(cause);
    }
}
