package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import java.util.List;
import javax.persistence.EntityExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
// @formatter:off
/**
  * Author : Pramuditya Ananta Nur
  * www.nantaaditya.com
  * personal@nantaaditya.com
  **/
// @formatter:on

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public void save(User user) {
    User check = userRepository.findOne(user.getId());
    if(ObjectUtils.isEmpty(check)){
      userRepository.save(user);
    }else{
      throw new EntityExistsException("User already exist");
    }
  }

  @Override
  public void delete(String id) {
    userRepository.delete(id);
  }

  @Override
  public List<User> get() {
    return userRepository.findAll();
  }
}
