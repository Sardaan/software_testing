package lab3.exceptions;

public class InvalidCoreException extends IllegalArgumentException {
    protected String message;

    public InvalidCoreException(String message) {
        this.message = message;
    }

    public InvalidCoreException() {
        message = "Invalid.";
    }

    public String getMessage() {
        return message;
    }
}
