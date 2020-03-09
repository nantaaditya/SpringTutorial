package com.example.demo.Controller;

import com.example.demo.Entity.Student;
import com.example.demo.Service.StudentService;
import com.example.demo.helper.StudentHelper;
import com.example.demo.model.DeleteRequest;
import com.example.demo.model.StudentWebRequest;
import com.example.demo.model.UpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
  public Student add(@RequestBody @Valid StudentWebRequest studentWebRequest) {
    return studentService.add(StudentHelper.copy(studentWebRequest , new Student()));
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

  @PutMapping(value = "/students/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public Student update(@RequestBody @Valid UpdateRequest updateRequest){
      return studentService.update(StudentHelper.copy(updateRequest, new Student()));
  }
  @DeleteMapping(value = "/students/delete",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public void delete(@RequestBody @Valid DeleteRequest deleteStudent){
    studentService.delete(StudentHelper.copy(deleteStudent, new Student()));
  }









//  @PutMapping(value ="/students/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//  public Student update(@RequestBody Student updateStudent, @PathVariable("id") String id){
//     return studentService.update(updateStudent, id);
//  }
//  @DeleteMapping(value = "/students/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//  public  void delete(@PathVariable("id") String id){
//      studentService.delete(id);
//  }

}
