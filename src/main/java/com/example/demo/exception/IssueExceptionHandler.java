package com.example.demo.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class IssueExceptionHandler {


    @ExceptionHandler
    @ResponseBody
    public String handleEmptyFiledException(EmptyFieldException exception){
    return exception.getMessage();
    }
}