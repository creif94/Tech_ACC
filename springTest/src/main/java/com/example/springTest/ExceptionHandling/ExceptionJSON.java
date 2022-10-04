package com.example.springTest.ExceptionHandling;

import org.springframework.http.HttpStatus;

public class ExceptionJSON {

    private String message;
    private Throwable cause;
    private HttpStatus status;

    public  ExceptionJSON(String message,HttpStatus status){
        this(message, status, null); //Passing to the next constructor, but with null cause
    }

    public ExceptionJSON(String message, HttpStatus status, Throwable cause){
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
