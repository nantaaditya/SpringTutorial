package com.example.demo.model;

import com.sun.javafx.collections.MappingChange;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

public class ErrorRequest {

private int code;
private String message;
//private Map<String, List<String>> error;

}
