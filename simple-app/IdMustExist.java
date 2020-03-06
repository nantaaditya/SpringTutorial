package com.example.demo.applicationdemo.validation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;
import java.lang.reflect.Field;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {IdMustExistValidator.class})
public @interface IdMustExist {
    String message();

    String[] path() default {};

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
