package com.example.springTest.ExceptionHandling;

public class ExcpetionSuper extends RuntimeException {


    public ExcpetionSuper(String msg) {
        super(msg);
    }
    public ExcpetionSuper(String msg, Throwable cause) {
        super(msg, cause);
    }
}
