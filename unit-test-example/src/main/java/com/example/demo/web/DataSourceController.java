package com.example.demo.web;

import com.example.demo.dto.DataSourceDTO;
import com.example.demo.service.DataSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
@RequestMapping(value = DataSourceController.DATA_SOURCE_API_PATH)
public class DataSourceController {

  public static final String DATA_SOURCE_API_PATH = "/data-source";

  @Autowired
  private DataSourceService dataSourceService;

  @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public DataSourceDTO get() throws Exception {
    return dataSourceService.readEnvironmentProperties();
  }
}
