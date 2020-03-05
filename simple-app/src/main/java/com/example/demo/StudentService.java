package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * created by pramuditya.anantanur
 **/
@Service
public class StudentService {
  private List<Student> students = new ArrayList<>();
  
  public void add(Student student) {
    students.add(student);
  }

  public List<Student> get() {
    return students;
  }

  public Student getById(String id) {
    return students.stream()
        .filter(student -> id.equals(student.getId()))
        .findFirst()
        .orElseGet(() -> null);
  }
  
  public Student updateStudent(String studentID, Student updateStudent){
	 for (Student student : students) {
		if(student.getId().equals(studentID)) {
			updateStudent.setId(studentID);
			students.set(students.indexOf(student), updateStudent);
			return updateStudent;
		}
	}
	 return null;
  }
  
  public Student deleteStudent(String studentID) {
      for (Student student : students) {
		if(student.getId().equals(studentID)) {
			students.remove(student);
			return student;
		}
	}
      return null;
  }
  
}
