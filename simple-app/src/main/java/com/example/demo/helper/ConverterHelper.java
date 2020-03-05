package com.example.demo.helper;

import org.springframework.beans.BeanUtils;

import java.util.Objects;

/**
 * created by pramuditya.anantanur
 **/
public class ConverterHelper {
  public static <SOURCE, TARGET> TARGET copy(SOURCE source, TARGET target) {
    if (Objects.isNull(source)) {
      return null;
    }
    BeanUtils.copyProperties(source, target);
    return target;
  }
}
