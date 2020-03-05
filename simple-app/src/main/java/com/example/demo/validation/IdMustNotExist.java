package com.example.demo.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * created by pramuditya.anantanur
 **/
@Target(FIELD)
@Retention(RUNTIME)
@Constraint(validatedBy = {IdMustNotExistValidator.class})
@Documented
public @interface IdMustNotExist {
  String message();

  String[] path() default {};

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
