package com.sanket.FirstJobApp.ExceptionHandler;

public class ResourceNotFoundError extends RuntimeException {

    public ResourceNotFoundError(String message) {
        super(message);
    }

}
