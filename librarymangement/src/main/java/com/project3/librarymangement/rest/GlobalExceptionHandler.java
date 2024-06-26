package com.project3.librarymangement.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler
  public ResponseEntity<ErrorResponse> handleException(UserNotFoundException notFoundException){
    ErrorResponse error = new ErrorResponse();
    error.setStatus(HttpStatus.NOT_FOUND.value());
    error.setMessage(notFoundException.getMessage());
    error.setTimeStamp(System.currentTimeMillis());

    return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler
  public ResponseEntity<ErrorResponse> bookHandleException(BookNotFoundException notFoundException){
    ErrorResponse error = new ErrorResponse();
    error.setStatus(HttpStatus.NOT_FOUND.value());
    error.setMessage(notFoundException.getMessage());
    error.setTimeStamp(System.currentTimeMillis());

    return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler
  public ResponseEntity<ErrorResponse> generalHandleException(Exception exception){
    ErrorResponse error = new ErrorResponse();
    error.setStatus(HttpStatus.BAD_REQUEST.value());
    error.setMessage(exception.getMessage());
    error.setTimeStamp(System.currentTimeMillis());

    return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
  }


}
