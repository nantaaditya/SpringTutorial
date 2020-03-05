package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
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
  @PutMapping(value ="/students/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public Student update(@RequestBody Student updateStudent, @PathVariable("id") String id){
     return studentService.update(updateStudent, id);
  }
  @DeleteMapping(value = "/students/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public  void delete(@PathVariable("id") String id){
      studentService.delete(id);
  }

}
