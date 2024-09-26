package com.mongodb.crud.exception;

public class NullResourceException extends RuntimeException {
    public NullResourceException(String message) {
        super(message);
    }
}
