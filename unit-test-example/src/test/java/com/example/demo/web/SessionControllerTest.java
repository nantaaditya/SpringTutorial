package com.example.demo.web;

import com.example.demo.entity.Session;
import com.example.demo.entity.User;
import com.example.demo.service.impl.SessionServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.util.Date;
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
public class SessionControllerTest {

  @InjectMocks
  private SessionController controller;

  @Mock
  private SessionServiceImpl service;

  private MockMvc mockMvc;
  private ObjectMapper mapper;

  private static final String SESSION_API_PATH = "/session";
  private static final String ID = "id";
  private static final String SESSION_ID = "sessionId";
  private static final String HOST = "host";
  private static final Date CREATED_DATE = new Date();
  private Session session;

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
    session = generateSession();
    mockMvc.perform(MockMvcRequestBuilders.post(SESSION_API_PATH)
        .content(mapper.writeValueAsString(session))
        .contentType(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(MockMvcResultMatchers.status().isOk());
    this.verifySave();
  }

  @Test
  public void testDelete() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.delete(SESSION_API_PATH+"/{id}", ID))
        .andExpect(MockMvcResultMatchers.status().isOk());
    this.verifyDelete();
  }

  private Session generateSession(){
    return Session.builder()
        .id(ID)
        .sessionId(SESSION_ID)
        .host(HOST)
        .createdDate(CREATED_DATE)
        .build();
  }

  private void verifySave() throws Exception {
    Mockito.verify(service).save(session);
  }

  private void verifyDelete() throws Exception {
    Mockito.verify(service).delete(ID);
  }

  @After
  public void tearDown() {
    Mockito.verifyNoMoreInteractions(service);
  }
}
