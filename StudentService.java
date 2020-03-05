package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * created by pramuditya.anantanur
 **/
@Service
public class StudentService {
	@Autowired
	  private StudentRepository studentRepository;
	  
	  public void add(Student student) {
	    studentRepository.save(student);
	  }

	  public List<Student> get() {
	    return studentRepository.findAll();
	  }

	  public Student getById(String id) {
	    return studentRepository.findById(id);
	  }
	  
	  public Student updateStudent(String id, Student studentUpdate) {
		  Student student = studentRepository.findById(id);
		  if(student == null) {
			  return null;
		  }
		  student.setId(id);
		  student.setAge(studentUpdate.getAge());
		  student.setName(studentUpdate.getName());
		  
		  return studentRepository.save(student);
	  }
	  
	  public void deleteStudent(String id) {
		  studentRepository.deleteById(id);
	  }
}
