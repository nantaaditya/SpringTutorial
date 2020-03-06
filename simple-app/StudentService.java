package com.example.demo.applicationdemo.service;

import com.example.demo.applicationdemo.entity.Student;
import com.example.demo.applicationdemo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Student> getById(String id) {
        return studentRepository.findById(id);
    }

    public Student updateStudent(Student updateStudent){
        return studentRepository.save(updateStudent);
    }

    public void deleteStudentById(Student deleteStudent){
        studentRepository.delete(deleteStudent);
    }
}
