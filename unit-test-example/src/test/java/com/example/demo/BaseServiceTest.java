package com.example.demo;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;
// @formatter:off
/**
  * Author : Pramuditya Ananta Nur
  * www.nantaaditya.com
  * personal@nantaaditya.com
  **/
// @formatter:on

@RunWith(SpringRunner.class)
public class BaseServiceTest {

  @Before
  public void setUp(){

  }

  @After
  public void tearDown(){

  }

  public void verifyNoMoreInteraction(Object o){
    verifyNoMoreInteractions(o);
  }
}
