package com.zane.shop.exception;

public class UserDoesNotHaveThatServiceException extends ServerException {
    public UserDoesNotHaveThatServiceException() {}
    public UserDoesNotHaveThatServiceException(String message) {
        super(message);
    }
    public UserDoesNotHaveThatServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
