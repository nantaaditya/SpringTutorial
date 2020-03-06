package com.example.demo.Validation;

import com.example.demo.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
@Component
public class idMustExistValidator implements ConstraintValidator<IdMustExist, String> {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void initialize(IdMustExist constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return studentRepository.exists(value);
    }
}
