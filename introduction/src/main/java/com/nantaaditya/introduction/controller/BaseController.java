package com.nantaaditya.introduction.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
// @formatter:off
/**
 * Author : Pramuditya Ananta Nur
  * www.nantaaditya.com
  * personal@nantaaditya.com
  **/
// @formatter:on

@RestController
public class BaseController {

  @GetMapping(value = "/")
  public String index() {
    return "Hello World";
  }
}
