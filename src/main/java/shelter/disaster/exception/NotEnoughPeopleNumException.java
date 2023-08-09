package shelter.disaster.exception;

public class NotEnoughPeopleNumException extends RuntimeException {
    public NotEnoughPeopleNumException() {
        super();
    }

    public NotEnoughPeopleNumException(String message) {
        super(message);
    }

    public NotEnoughPeopleNumException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotEnoughPeopleNumException(Throwable cause) {
        super(cause);
    }

    protected NotEnoughPeopleNumException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
