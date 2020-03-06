package com.example.demo.applicationdemo.model;

import com.example.demo.applicationdemo.validation.IdMustExist;
import com.example.demo.applicationdemo.validation.IdMustNotExist;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentWebDeleteRequest {
    @NotBlank(message = "NotBlank")
    @IdMustExist(message = "MustExist")
    private String id;
}
