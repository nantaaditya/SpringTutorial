package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * created by pramuditya.anantanur
 **/
@RestController
public class StudentController {
  
  @Autowired
  private StudentService studentService;
  
  @PostMapping(
      value = "/students",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE
  )
  public Student add(@RequestBody Student student) {
    studentService.add(student);
    return student;
  }
  
  @GetMapping(
      value = "/students",
      produces = MediaType.APPLICATION_JSON_VALUE
  )
  public List<Student> findAll() {
    return studentService.get();
  }

  @GetMapping(
      value = "/students/{id}",
      produces = MediaType.APPLICATION_JSON_VALUE
  )
  public Student getById(@PathVariable String id) {
    return studentService.getById(id);
  }

}
