package com.sourabh.Restful_web_services.Exceptions;

import com.sourabh.Restful_web_services.user.userNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception{
        ErrorDetails ErrorDetailsObj=new ErrorDetails(LocalDateTime.now(),ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(ErrorDetailsObj, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(userNotFoundException.class)
    public final ResponseEntity<Object> handleuserNotFoundException(Exception ex, WebRequest request) throws Exception{
        ErrorDetails ErrorDetailsObj=new ErrorDetails(LocalDateTime.now(),ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(ErrorDetailsObj, HttpStatus.NOT_FOUND);
    }
}

