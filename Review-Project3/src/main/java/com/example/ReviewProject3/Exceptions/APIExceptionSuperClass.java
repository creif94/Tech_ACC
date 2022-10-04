package com.example.ReviewProject3.Exceptions;

public class APIExceptionSuperClass extends RuntimeException{
    public APIExceptionSuperClass(String message) {super(message);}
    public APIExceptionSuperClass(String message, Throwable cause) {super(message, cause);}


}
