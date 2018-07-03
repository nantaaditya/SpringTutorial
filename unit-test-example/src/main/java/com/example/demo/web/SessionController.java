package com.example.demo.web;

import com.example.demo.entity.Session;
import com.example.demo.service.SessionService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
// @formatter:off
/**
  * Author : Pramuditya Ananta Nur
  * www.nantaaditya.com
  * personal@nantaaditya.com
  **/
// @formatter:on

@RestController
@RequestMapping(value = SessionController.SESSION_API_PATH)
public class SessionController {

  public static final String SESSION_API_PATH = "/session";

  @Autowired
  private SessionService sessionService;

  @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
  public void save(@RequestBody @Valid Session session) {
    sessionService.save(session);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public void delete(@PathVariable String id) {
    sessionService.delete(id);
  }
}
