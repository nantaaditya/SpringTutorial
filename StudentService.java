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
  public Student update(Student updateStudent, String id){
    // gunakan ini kalao kita mau melooping tetapi tidak ingin mengambil indexnya
//    students.forEach(student -> {
//      if(id.equals(student.getId())) {
////        student.setAge(updateStudent.getAge());
////        student.setName(updateStudent.getName());
//        // bean utills untuk update satu baris dari suatu list tapi hanya bisa berupa int string dll
//        BeanUtils.copyProperties(updateStudent, student);
//      }
//    });
//    return updateStudent;
    int idx=0;
    for (Student updateStudents:students) {
        if(id.equals(updateStudent.getId()));
      {
        students.set(idx, updateStudent);
      }
      idx++;
    }
    return updateStudent;
  }
  public void delete(String id){
     students.removeIf(student -> student.getId().equals(id));

  }

}
