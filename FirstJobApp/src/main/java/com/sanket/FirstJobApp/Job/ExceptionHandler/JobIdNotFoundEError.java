package com.sanket.FirstJobApp.ExceptionHandler;

public class JobIdNotFoundEError extends RuntimeException {

    public JobIdNotFoundEError(String message) {
        super(message);
    }

}
