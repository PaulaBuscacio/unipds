package net.buscacio;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;

@Liveness // nao chamar a classe de readiness ou liveness para nao confundor com a anotacao
public class LivenessCheck implements HealthCheck {

  @Override
  public HealthCheckResponse call(){
    return HealthCheckResponse.up("Liveness Check");
  }
}
