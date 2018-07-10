package com.example.demo.web;

import com.example.demo.service.impl.DataSourceServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
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
public class DataSourceControllerTest {

  @InjectMocks
  private DataSourceController controller;

  @Mock
  private DataSourceServiceImpl service;

  private MockMvc mockMvc;
  private ObjectMapper mapper;

  private static final String DATA_SOURCE_API_PATH = "/data-source";

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
  public void testGet() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get(DATA_SOURCE_API_PATH))
        .andExpect(MockMvcResultMatchers.status().isOk());
    this.verifyReadEnvironmentProperties();
  }

  private void verifyReadEnvironmentProperties() throws Exception {
    Mockito.verify(service).readEnvironmentProperties();
  }

  @After
  public void tearDown() {
    Mockito.verifyNoMoreInteractions(service);
  }
}
