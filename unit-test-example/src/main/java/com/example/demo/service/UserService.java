package com.example.demo.service;

import com.example.demo.entity.User;
import java.util.List;
// @formatter:off
/**
  * Author : Pramuditya Ananta Nur
  * www.nantaaditya.com
  * personal@nantaaditya.com
  **/
// @formatter:on

public interface UserService {

  void save(User user);

  void delete(String id);

  List<User> get();
}
