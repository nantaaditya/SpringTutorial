package com.example.demo.service;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;

import com.example.demo.BaseServiceTest;
import com.example.demo.entity.Session;
import com.example.demo.repository.SessionRepository;
import com.example.demo.service.impl.SessionServiceImpl;
import java.util.Date;
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

public class SessionServiceImplTest extends BaseServiceTest {

  @InjectMocks
  private SessionServiceImpl sessionService;

  @Mock
  private SessionRepository sessionRepository;

  private Session session;
  private static final String ID = "id";
  private static final String SESSION_ID = "sessionId";
  private static final String HOST = "host";
  private static final Date CREATED_DATE = new Date();

  @Override
  public void setUp() {
    session = generateSession();
  }

  @Test
  public void testSave() {
    sessionService.save(session);
    verify(sessionRepository).save(any(Session.class));
  }

  @Test
  public void testDelete(){
    sessionService.delete(ID);
    verify(sessionRepository).delete(anyString());
  }

  @Override
  public void tearDown() {
    super.verifyNoMoreInteraction(sessionRepository);
  }

  private Session generateSession() {
    return Session.builder()
        .id(ID)
        .sessionId(SESSION_ID)
        .host(HOST)
        .createdDate(CREATED_DATE)
        .build();
  }
}
