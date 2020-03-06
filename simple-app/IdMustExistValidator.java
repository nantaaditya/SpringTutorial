package com.example.demo.applicationdemo.validation;

import com.example.demo.applicationdemo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class IdMustExistValidator implements ConstraintValidator<IdMustExist, String> {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return studentRepository.existsById(value) || StringUtils.isEmpty(value);
    }
}
