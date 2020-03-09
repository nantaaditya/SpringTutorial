package com.example.demo.Validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(FIELD)
@Retention(RUNTIME)
@Constraint(validatedBy = {idMustNotExistValidator.class})
@Documented
public @interface IdMustNotExist {
    String message();

    String[] path() default {};

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
