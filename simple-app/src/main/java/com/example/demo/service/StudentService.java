package com.example.demo.service;

import com.example.demo.repository.StudentRepository;
import com.example.demo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * created by pramuditya.anantanur
 **/
@Service
public class StudentService {
  @Autowired
  private StudentRepository studentRepository;
  
  public Student add(Student student) {
    return studentRepository.save(student);
  }

  public List<Student> get() {
    return studentRepository.findAll();
  }

  public Student getById(String id) {
    return studentRepository.findById(id);
  }
  
}
