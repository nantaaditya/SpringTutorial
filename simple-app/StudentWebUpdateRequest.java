package com.example.demo.applicationdemo.model;

import com.example.demo.applicationdemo.validation.IdMustExist;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentWebUpdateRequest {
    @NotBlank(message = "NotBlank")
    @IdMustExist(message = "NotExist")
    private String id;
    @Size(min = 4, max = 20)
    @NotBlank(message = "NotBlank")
    private String name;
    @Min(value = 1, message = "MustGreaterThanOne")
    private int age;
}
