package net.buscacio;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Readiness
public class ReadinessCheck implements HealthCheck {

  @RestClient
  StarWarsService starWarsService;

  @Override
  public HealthCheckResponse call(){

    if(starWarsService.getStarships().equals(StarWarsService.ERROR_MSG)){
      return HealthCheckResponse.down("Readiness Check");
    }
    return HealthCheckResponse.up("Readiness Check");
  }
}
