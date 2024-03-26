package org.doogle.configclient;

import org.springframework.cloud.endpoint.RefreshEndpoint;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ActuatorRefreshScheduler {

  private final RefreshEndpoint refreshEndpoint;

  public ActuatorRefreshScheduler(RefreshEndpoint refreshEndpoint) {
    this.refreshEndpoint = refreshEndpoint;
  }

  @Scheduled(fixedRate = 60000) // 60000 milliseconds = 1 minute
  public void refreshActuator() {
    Object result = refreshEndpoint.refresh();
    System.out.println("Response from /actuator/refresh: " + result);
  }
}