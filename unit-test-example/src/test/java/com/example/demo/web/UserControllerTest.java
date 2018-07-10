package com.example.demo.web;

import com.example.demo.entity.User;
import com.example.demo.service.impl.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;
// @formatter:off
/**
  * Author : Pramuditya Ananta Nur
  * www.nantaaditya.com
  * personal@nantaaditya.com
  **/
// @formatter:on
@RunWith(SpringRunner.class)
public class UserControllerTest {

  @InjectMocks
  private UserController controller;

  @Mock
  private UserServiceImpl service;

  private MockMvc mockMvc;
  private ObjectMapper mapper;

  private static final String USER_API_PATH = "/user";
  private static final String ID = "id";
  private static final String USERNAME = "username";
  private static final String PASSWORD = "password";
  private static final String NAME = "name";
  private static final boolean ACTIVE = true;
  private User user;

  @Before
  public void setUp() {
    this.mapper = new ObjectMapper();
    this.mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    this.mockMvc = MockMvcBuilders
        .standaloneSetup(controller)
        .setHandlerExceptionResolvers(new ExceptionHandlerExceptionResolver())
        .setMessageConverters(new MappingJackson2HttpMessageConverter(mapper))
        .build();
  }

  @Test
  public void testSave() throws Exception {
    user = generateUser();
    mockMvc.perform(MockMvcRequestBuilders.post(USER_API_PATH)
        .content(mapper.writeValueAsString(user))
        .contentType(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(MockMvcResultMatchers.status().isOk());
    this.verifySave();
  }

  @Test
  public void testDelete() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.delete(USER_API_PATH+"/{id}", ID))
        .andExpect(MockMvcResultMatchers.status().isOk());
    this.verifyDelete();
  }

  @Test
  public void testGet() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get(USER_API_PATH))
        .andExpect(MockMvcResultMatchers.status().isOk());
    this.verifyGet();
  }

  private User generateUser(){
    return User.builder()
        .id(ID)
        .username(USERNAME)
        .password(PASSWORD)
        .name(NAME)
        .active(ACTIVE)
        .build();
  }

  private void verifySave() throws Exception {
    Mockito.verify(service).save(user);
  }

  private void verifyDelete() throws Exception {
    Mockito.verify(service).delete(ID);
  }

  private void verifyGet() throws Exception {
    Mockito.verify(service).get();
  }

  @After
  public void tearDown() {
    Mockito.verifyNoMoreInteractions(service);
  }
}
