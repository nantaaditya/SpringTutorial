package com.example.demo.model;

import com.example.demo.Validation.IdMustNotExist;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentWebRequest {
  //  @NotBlank(message = "NotBlank")
    @IdMustNotExist(message = "Must Not Exist")
    private String id;
  //  @NotBlank(message = "NotBlank")
    @Size(min = 4, max = 20, message = "harus lebih dari 4 dan kurang dari 20")
    private String name;
    @Min(value = 0, message = "lebih besa dari 0")
    private int age;
}
