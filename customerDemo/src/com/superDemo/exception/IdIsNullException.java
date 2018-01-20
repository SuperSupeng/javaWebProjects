package com.superDemo.exception;

public class IdIsNullException extends Exception {
    public IdIsNullException() {
    }

    public IdIsNullException(String message) {
        super(message);
    }

    public IdIsNullException(String message, Throwable cause) {
        super(message, cause);
    }

    public IdIsNullException(Throwable cause) {
        super(cause);
    }

    public IdIsNullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
