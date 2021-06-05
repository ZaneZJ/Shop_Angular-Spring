package com.zane.shop.exception;

public class EmailAlreadyExistsException extends ServerException {
    public EmailAlreadyExistsException() {
        super();
    }
    public EmailAlreadyExistsException(String message) {
        super(message);
    }
    public EmailAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
