package org.doogle.configclient;


import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data")
public class ValueController {

  private final DynamicConfigurations dynamicConfigurations;
  @Value("${rest.application.environment:#{null}}")
  public String environment;

  public ValueController(DynamicConfigurations dynamicConfigurations) {
    this.dynamicConfigurations = dynamicConfigurations;
  }

  @GetMapping("/")
  public Map<String, String> getProperties() {
    return Map.of("environment", dynamicConfigurations.getEnvironment());
  }

}
