package com.example.demo.controller;

import com.example.demo.helper.ErrorHelper;
import com.example.demo.model.ErrorModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * created by pramuditya.anantanur
 **/
@RestControllerAdvice
public class ExceptionHandlerController {
  
  @Autowired
  private MessageSource messageSource;
  
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ErrorModel handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
    return ErrorModel.builder()
        .code(HttpStatus.BAD_REQUEST.value())
        .message(HttpStatus.BAD_REQUEST.getReasonPhrase())
        .errors(ErrorHelper.from(ex.getBindingResult(), messageSource))
        .build();
  }
}
