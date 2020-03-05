package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
}
