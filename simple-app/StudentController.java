package com.example.demo.applicationdemo.controller;

import com.example.demo.applicationdemo.entity.Student;
import com.example.demo.applicationdemo.helper.ConverterHelper;
import com.example.demo.applicationdemo.model.StudentWebDeleteRequest;
import com.example.demo.applicationdemo.model.StudentWebRequest;
import com.example.demo.applicationdemo.model.StudentWebUpdateRequest;
import com.example.demo.applicationdemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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
        return studentService.add(ConverterHelper.copy(studentWebRequest, new Student()));
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
    public Optional<Student> getById(@PathVariable String id) {
        return studentService.getById(id);
    }

    @PutMapping(
            value = "/students/update",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Student updateStudent(@RequestBody @Valid StudentWebUpdateRequest studentWebUpdateRequest){
        return studentService.updateStudent(ConverterHelper.copy(studentWebUpdateRequest, new Student()));
    }

    @DeleteMapping(
            value =  "/students/delete",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public void studentDeleteById(@RequestBody @Valid StudentWebDeleteRequest studentWebDeleteRequest){
        studentService.deleteStudentById(ConverterHelper.copy(studentWebDeleteRequest, new Student()));
    }

}
