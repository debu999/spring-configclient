package org.doogle.configclient;


import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data")
@RefreshScope
public class ValueController {

  @Value("${rest.application.environment:#{null}}")
  public String environment;


  @GetMapping("/")
  public Map<String, String> getProperties() {
    return Map.of("environment", environment);
  }

}
