package com.zane.shop.exception;

public class ServiceHasTooManyInstancesException extends ServerException {
    public ServiceHasTooManyInstancesException() {
        super();
    }
    public ServiceHasTooManyInstancesException(String message) {
        super(message);
    }
    public ServiceHasTooManyInstancesException(String message, Throwable cause) {
        super(message, cause);
    }
}
