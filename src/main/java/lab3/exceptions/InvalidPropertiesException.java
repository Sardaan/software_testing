package lab3.exceptions;

public class InvalidPropertiesException extends InvalidCoreException{
    public InvalidPropertiesException(String message) {
        super(message);
    }

    public InvalidPropertiesException() {
        super.message = "Empty file.";
    }
}
