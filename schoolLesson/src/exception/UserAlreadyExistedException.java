package exception;

public class UserAlreadyExistedException extends Exception {
    public UserAlreadyExistedException() {
    }

    public UserAlreadyExistedException(String message) {
        super(message);
    }

    public UserAlreadyExistedException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserAlreadyExistedException(Throwable cause) {
        super(cause);
    }

    public UserAlreadyExistedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
