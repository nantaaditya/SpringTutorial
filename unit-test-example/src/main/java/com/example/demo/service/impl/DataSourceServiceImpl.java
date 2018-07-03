package com.example.demo.service.impl;

import com.example.demo.dto.DataSourceDTO;
import com.example.demo.service.DataSourceService;
import java.util.Optional;
import org.springframework.stereotype.Service;
// @formatter:off
/**
  * Author : Pramuditya Ananta Nur
  * www.nantaaditya.com
  * personal@nantaaditya.com
  **/
// @formatter:on

@Service
public class DataSourceServiceImpl implements DataSourceService {

  @Override
  public DataSourceDTO readEnvironmentProperties() throws Exception {
    String hostname = Optional.ofNullable(System.getenv("PSGR_HOSTNAME"))
        .orElseThrow(() -> new Exception("Environment Variable not exist"));
    String port = Optional.ofNullable(System.getenv("PSGR_PORT"))
        .orElseThrow(() -> new Exception("Environment Variable not exist"));
    String username = Optional.ofNullable(System.getenv("PSGR_DB_USERNAME"))
        .orElseThrow(() -> new Exception("Environment Variable not exist"));
    String password = Optional.ofNullable(System.getenv("PSGR_DB_PASSWORD"))
        .orElseThrow(() -> new Exception("Environment Variable not exist"));

    return DataSourceDTO.builder().hostname(hostname).port(port).username(username)
        .password(password).build();
  }
}
