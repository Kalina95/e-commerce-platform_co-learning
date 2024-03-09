package com.ecommerce.contentservice.exception;

public class NoSuchComponentException extends RuntimeException {
    public NoSuchComponentException(String message, Throwable exception) {
        super(message, exception);
    }

    public NoSuchComponentException(String message) {
        super(message);
    }
}
