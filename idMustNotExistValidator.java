package com.example.demo.Validation;

import com.example.demo.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
@Component
public class idMustNotExistValidator implements ConstraintValidator<IdMustNotExist, String> {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void initialize(IdMustNotExist constraintAnnotation) {

    }
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return StringUtils.isEmpty(value)|| !studentRepository.exists(value);
    }
}
