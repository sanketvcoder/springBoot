package com.sanket.FirstJobApp.Job.ExceptionHandler;

public class ResourceNotFoundError extends RuntimeException {

    public ResourceNotFoundError(String message) {
        super(message);
    }

}
