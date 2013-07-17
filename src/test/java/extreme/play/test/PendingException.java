package extreme.play.test;

public class PendingException extends Exception {
    public PendingException() {
        super();
    }

    public PendingException(String message) {
        super(message);
    }

    public PendingException(String message, Throwable cause) {
        super(message, cause);
    }

    public PendingException(Throwable cause) {
        super(cause);
    }

    public PendingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
