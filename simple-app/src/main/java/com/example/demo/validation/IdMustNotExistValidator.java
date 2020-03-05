package com.example.demo.validation;

import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * created by pramuditya.anantanur
 **/
@Component
public class IdMustNotExistValidator implements ConstraintValidator<IdMustNotExist, String> {
  
  @Autowired
  private StudentRepository studentRepository;
  
  @Override
  public void initialize(IdMustNotExist constraintAnnotation) {
    
  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    return StringUtils.isEmpty(value) || !studentRepository.exists(value);
  }
}
