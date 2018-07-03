package com.example.demo.service.impl;

import com.example.demo.entity.Session;
import com.example.demo.repository.SessionRepository;
import com.example.demo.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
// @formatter:off
/**
  * Author : Pramuditya Ananta Nur
  * www.nantaaditya.com
  * personal@nantaaditya.com
  **/
// @formatter:on

@Service
public class SessionServiceImpl implements SessionService {

  @Autowired
  private SessionRepository sessionRepository;

  @Override
  public void save(Session session) {
    sessionRepository.save(session);
  }

  @Override
  public void delete(String id) {
    sessionRepository.delete(id);
  }
}
