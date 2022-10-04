package com.example.ReviewProject3.Exceptions;

import org.springframework.http.HttpStatus;

public class APIExceptionClass {
    private String message;
    private Throwable cause;
    private HttpStatus status;

    public APIExceptionClass(String message) {
        this.message = message;
    }

    public APIExceptionClass(String message, Throwable cause) {
        this.message = message;
        this.cause = cause;
    }
    public APIExceptionClass(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }
    public APIExceptionClass(String message, Throwable cause, HttpStatus status) {
        this.message = message;
        this.cause = cause;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public Throwable getCause() {
        return cause;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
