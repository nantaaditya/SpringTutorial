package com.example.demo.service;

import com.example.demo.dto.DataSourceDTO;
// @formatter:off
/**
  * Author : Pramuditya Ananta Nur
  * www.nantaaditya.com
  * personal@nantaaditya.com
  **/
// @formatter:on

public interface DataSourceService {

  DataSourceDTO readEnvironmentProperties() throws Exception;
}
