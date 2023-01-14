package ru.platform.demo.services.exceptions;

public class AccountIsAlreadyExistException extends Exception {
    public AccountIsAlreadyExistException() {
    }

    public AccountIsAlreadyExistException(String message) {
        super(message);
    }

    public AccountIsAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccountIsAlreadyExistException(Throwable cause) {
        super(cause);
    }

    public AccountIsAlreadyExistException(
            String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
