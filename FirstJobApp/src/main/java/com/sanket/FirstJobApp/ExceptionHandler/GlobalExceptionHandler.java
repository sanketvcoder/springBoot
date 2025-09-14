package com.sanket.FirstJobApp.ExceptionHandler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(JobIdNotFoundEError.class)
    public String handleJobIdNotFoundEError(JobIdNotFoundEError ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(ResourceNotFoundError.class)
    public String handleResourceNotFoundError(ResourceNotFoundError ex) {
        return ex.getMessage();

    }
}
