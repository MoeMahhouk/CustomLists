package errors;

public class QueueIsEmptyException extends Exception {
    public QueueIsEmptyException(String message) {
        super(message);
    }
    public QueueIsEmptyException(String message, Throwable cause) {
        super(message, cause);
    }
}
