package com.example.demo.model;

import com.example.demo.validation.IdMustNotExist;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;

/**
 * created by pramuditya.anantanur
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentWebRequest {
  @NotBlank(message = "NotBlank")
  @IdMustNotExist(message = "MustNotExist")
  private String id;
  @NotBlank(message = "NotBlank")
  private String name;
  @Min(value = 1, message = "MustGreaterThanOne")
  private int age;
}
