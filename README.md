# Spring Config Client Project

This project is a Spring Config Client that connects to a Config Server to fetch its configuration.
The client is set up to refresh its configuration every 60 seconds.

## Project Setup

This project is built using Java 21, Spring Boot 3.2.4, Spring Cloud 2023.0.0, and Maven.

## Dependencies

The project uses the following dependencies:

- Spring Boot Starter Actuator
- Spring Cloud Starter
- Spring Cloud Starter Config
- Lombok
- Spring Boot Starter Test
- Spring Boot Starter Web

## Configuration Refresh

The Config Client is set up to automatically refresh its configuration from the Config Server every
60 seconds. This is achieved by using the `@RefreshScope` annotation on the beans that need to be
refreshed, and setting up a scheduled task that calls the `/actuator/refresh` endpoint every 60
seconds.

Here is an example of how to use the `@RefreshScope` annotation:

```java

@RefreshScope
@RestController
@RequestMapping("/data")
public class ValueController {

  @Value("${rest.application.environment:#{null}}")
  public String environment;

  @GetMapping("/")
  public Map<String, String> getProperties() {
    return Map.of("environment", environment);
  }

}
```

In the above example, the `rest.application.environment` value will be
refreshed `every 60 seconds`.  
Running the Project
To run the project, use the following command:
`mvn spring-boot:run`

This will start the Config Client, which will connect to the Config Server and fetch the
configuration. The configuration will be refreshed every 60 seconds.

Contact
If you have any questions or issues, please open an issue on GitHub.

Please replace `rest.application.environment` and `ValueController` with your actual property and
controller names.