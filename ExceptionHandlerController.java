package com.example.demo.applicationdemo.controller;

import com.example.demo.applicationdemo.Exception.PathNotFound;
import com.example.demo.applicationdemo.helper.ErrorHelper;
import com.example.demo.applicationdemo.model.ErrorModel;
import com.example.demo.applicationdemo.model.ErrorModelRequest;
import com.jayway.jsonpath.PathNotFoundException;
import org.hibernate.boot.MappingNotFoundException;
import org.omg.CORBA.OBJECT_NOT_EXIST;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.mapping.MappingException;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLException;

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
//                .errors(ErrorHelper.from(ex.getBindingResult(), messageSource))
                .build();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResourceNotFoundException.class)
    public ErrorModelRequest handleNotFoundRequest(ResourceNotFoundException ex){
        return ErrorModelRequest.builder()
                .code(HttpStatus.NOT_FOUND.value())
                .message(HttpStatus.NOT_FOUND.getReasonPhrase())
                .build();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorModelRequest handleInternalServerError(Exception ex){
        return ErrorModelRequest.builder()
                .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                .build();
    }
}
