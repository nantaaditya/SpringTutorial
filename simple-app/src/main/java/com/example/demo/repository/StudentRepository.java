package com.example.demo.repository;

import com.example.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * created by pramuditya.anantanur
 **/
@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
  Student findById(String id);
}
