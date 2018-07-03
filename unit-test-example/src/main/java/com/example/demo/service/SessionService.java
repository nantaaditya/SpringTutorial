package com.example.demo.service;

import com.example.demo.entity.Session;
// @formatter:off
/**
  * Author : Pramuditya Ananta Nur
  * www.nantaaditya.com
  * personal@nantaaditya.com
  **/
// @formatter:on

public interface SessionService {

  void save(Session session);

  void delete(String id);
}
