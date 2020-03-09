package com.example.demo.model;

import com.example.demo.Validation.IdMustExist;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeleteRequest {
    @IdMustExist(message = "ID telah terupdate")
 //   @NotBlank(message = "NotBlank")
    private String id;
}
