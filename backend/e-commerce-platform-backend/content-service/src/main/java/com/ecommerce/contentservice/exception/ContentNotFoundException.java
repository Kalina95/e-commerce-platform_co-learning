package com.ecommerce.contentservice.exception;

public class ContentNotFoundException extends RuntimeException{

    public ContentNotFoundException(String message, Throwable exception){
        super(message, exception);
    }

    public ContentNotFoundException(String message){
        super(message);
    }
}
