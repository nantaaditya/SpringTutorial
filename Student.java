package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.lang.annotation.Documented;

/**
 * created by pramuditya.anantanur
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "students")
public class Student {
  @Id
  private String id;
  private String name;
  private int age;

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }


}
