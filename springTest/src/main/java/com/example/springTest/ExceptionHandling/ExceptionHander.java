package com.example.springTest.ExceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
@ControllerAdvice

public class ExceptionHander {

    @ExceptionHandler(value = ExcpetionSuper.class)
    public ResponseEntity<Object> handleExceptions(ExcpetionSuper e) {
        HttpStatus badRequest = BAD_REQUEST;
        // If i wanted to pass in the cause, I need to put e after Bad_Request
        ExceptionJSON exception = new ExceptionJSON(e.getMessage(),BAD_REQUEST);
        return new ResponseEntity<>(exception,BAD_REQUEST);
    }
}
