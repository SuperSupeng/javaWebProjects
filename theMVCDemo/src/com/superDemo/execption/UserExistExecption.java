package com.superDemo.execption;

public class UserExistExecption extends Exception {

    public UserExistExecption() {
        super();
    }

    public UserExistExecption(String message) {
        super(message);
    }

    public UserExistExecption(String message, Throwable cause) {
        super(message, cause);
    }

    public UserExistExecption(Throwable cause) {
        super(cause);
    }

    protected UserExistExecption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
