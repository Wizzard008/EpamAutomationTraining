package JavaExceptions;

public class ExceptionAnsenceOfFacultiesAtUniversity extends Exception{
    public ExceptionAnsenceOfFacultiesAtUniversity() {
    }

    public ExceptionAnsenceOfFacultiesAtUniversity(String message) {
        super(message);
    }

    public ExceptionAnsenceOfFacultiesAtUniversity(String message, Throwable cause) {
        super(message, cause);
    }

    public ExceptionAnsenceOfFacultiesAtUniversity(Throwable cause) {
        super(cause);
    }
}
