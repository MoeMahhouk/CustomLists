package errors;

public class StackIsEmptyException extends Exception {
    public StackIsEmptyException(String message) {
        super(message);
    }

    public StackIsEmptyException(String message, Throwable cause) {
        super(message, cause);
    }
}
