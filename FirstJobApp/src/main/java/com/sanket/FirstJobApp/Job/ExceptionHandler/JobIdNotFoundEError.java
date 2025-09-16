package com.sanket.FirstJobApp.Job.ExceptionHandler;

public class JobIdNotFoundEError extends RuntimeException {

    public JobIdNotFoundEError(String message) {
        super(message);
    }

}
