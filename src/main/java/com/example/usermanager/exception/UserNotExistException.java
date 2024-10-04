package com.example.usermanager.exception;

public class UserNotExistException extends RuntimeException{
    public UserNotExistException(String message) {
        super(message);
    }

    public UserNotExistException(String message, Throwable cause) {
        super(message, cause);
    }
}
