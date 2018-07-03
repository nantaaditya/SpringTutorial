package com.example.demo.service;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.junit.Assert.assertEquals;

import com.example.demo.BaseServiceTest;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.impl.UserServiceImpl;
import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityExistsException;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
// @formatter:off
/**
  * Author : Pramuditya Ananta Nur
  * www.nantaaditya.com
  * personal@nantaaditya.com
  **/
// @formatter:on

public class UserServiceImplTest extends BaseServiceTest {

  @InjectMocks
  private UserServiceImpl userService;

  @Mock
  private UserRepository userRepository;

  private User user;
  private static final String ID = "id";
  private static final String USERNAME = "username";
  private static final String PASSWORD = "password";
  private static final String NAME = "name";
  private static final boolean ACTIVE = true;

  @Override
  public void setUp() {
    super.setUp();
  }

  @Test
  public void testSave() {
    user = generateUser();
    this.mockFindOne();
    userService.save(user);
    this.verifyFindOne();
    this.verifySave(1);
  }

  @Test(expected = EntityExistsException.class)
  public void testSaveFailed() {
    user = generateUser();
    this.mockFailedFindOne();
    try {
      userService.save(user);
    } catch (Exception e) {
      this.verifyFindOne();
      this.verifySave(0);
      throw e;
    }
  }

  @Test
  public void testDelete() {
    userService.delete(ID);
    this.verifyDelete();
  }

  @Test
  public void testGet() {
    user = generateUser();
    this.mockFindAll();
    List<User> result = userService.get();
    assertGet(result.get(0));
    this.verifyFindAll();
  }

  @Override
  public void tearDown() {
    super.tearDown();
    super.verifyNoMoreInteraction(userRepository);
  }

  private void mockFindOne() {
    when(userRepository.findOne(anyString())).thenReturn(null);
  }

  private void mockFailedFindOne() {
    when(userRepository.findOne(anyString())).thenReturn(user);
  }

  private void mockFindAll() {
    when(userRepository.findAll()).thenReturn(Arrays.asList(user));
  }

  private void assertGet(User userResult) {
    assertEquals(ID, userResult.getId());
    assertEquals(USERNAME, userResult.getUsername());
    assertEquals(PASSWORD, userResult.getPassword());
    assertEquals(NAME, userResult.getName());
    assertTrue(userResult.isActive());
  }

  private void verifyFindOne() {
    verify(userRepository).findOne(anyString());
  }

  private void verifySave(int time) {
    verify(userRepository, times(time)).save(any(User.class));
  }

  private void verifyDelete() {
    verify(userRepository).delete(anyString());
  }

  private void verifyFindAll() {
    verify(userRepository).findAll();
  }

  private User generateUser() {
    return User.builder().id(ID).username(USERNAME).password(PASSWORD).name(NAME).active(ACTIVE)
        .build();
  }

}
