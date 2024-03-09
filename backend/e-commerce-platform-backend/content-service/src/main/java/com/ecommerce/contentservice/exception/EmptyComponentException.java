package com.ecommerce.contentservice.exception;

public class EmptyComponentException extends RuntimeException {
    public EmptyComponentException(String message, Throwable exception) {
        super(message, exception);
    }

    public EmptyComponentException(String message) {
        super(message);
    }
}
