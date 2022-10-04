package com.example.ReviewProject3.Exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class APIExceptionHandler {

    @ExceptionHandler(value={APIExceptionSuperClass.class, }) //wait for any exception of this type
    public ResponseEntity<Object> APIExceptionHandler(APIExceptionSuperClass e){
        HttpStatus Bad_Request = HttpStatus.BAD_REQUEST;
        APIExceptionClass exception = new APIExceptionClass(
                e.getMessage(),
//                e,
                Bad_Request
                );
        return new ResponseEntity<>(exception,HttpStatus.BAD_REQUEST);
    }
}
