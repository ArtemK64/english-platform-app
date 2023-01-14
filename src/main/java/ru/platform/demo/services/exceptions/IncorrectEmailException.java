package ru.platform.demo.services.exceptions;

public class IncorrectEmailException extends Exception {
    public IncorrectEmailException() {
    }

    public IncorrectEmailException(String message) {
        super(message);
    }

    public IncorrectEmailException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectEmailException(Throwable cause) {
        super(cause);
    }

    public IncorrectEmailException(
            String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}