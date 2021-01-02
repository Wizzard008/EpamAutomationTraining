package JavaExceptions;

public class ExceptionMarkLessZeroOrGreaterTen extends Exception {
    public ExceptionMarkLessZeroOrGreaterTen() {
    }

    public ExceptionMarkLessZeroOrGreaterTen(String message) {
        super(message);
    }

    public ExceptionMarkLessZeroOrGreaterTen(String message, Throwable cause) {
        super(message, cause);
    }

    public ExceptionMarkLessZeroOrGreaterTen(Throwable cause) {
        super(cause);
    }
}
