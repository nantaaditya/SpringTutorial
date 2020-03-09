package com.example.demo.helper;

import org.springframework.beans.BeanUtils;

import java.util.Objects;

public class StudentHelper {
    public static<SOURCE, TARGET> TARGET copy(SOURCE source, TARGET target){
        if(Objects.isNull(source)){
            return null;
        }
        BeanUtils.copyProperties(source, target);
        return target;
    }
}
