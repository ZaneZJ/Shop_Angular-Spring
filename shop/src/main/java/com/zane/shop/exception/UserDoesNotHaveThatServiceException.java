package com.zane.shop.exception;

public class UserDoesNotHaveThatServiceException extends ServerException {
    public UserDoesNotHaveThatServiceException() {
        super();
    }
    public UserDoesNotHaveThatServiceException(String message) {
        super(message);
    }
    public UserDoesNotHaveThatServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
