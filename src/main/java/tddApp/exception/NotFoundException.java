package tddApp.exception;

/**
 * Created by galik on 15.10.2017.
 */
public class NotFoundException extends Exception {

    public NotFoundException(String message) {
        super(message);
    }

    public String getMessage()
    {
        return super.getMessage();
    }
}
