package net.buscacio;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(baseUri = "https://swapi.info/api")
public interface StarWarsService {

  String ERROR_MSG = "fallback";

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("starships")
  @Timeout(value = 3000L)
  @Fallback(fallbackMethod = "getStarShipsFallback")
  @CircuitBreaker(
      requestVolumeThreshold = 2, //default 20
      failureRatio = 0.5,
      delay = 3000L, //tempo para tentar fechar o circuito novamente
      successThreshold = 2 //numero de chamadas bem sucedidas para fechar o circuito
  )
  public String getStarships();

  //o metodo de fallback deve ter a mesma assinatura (parametros e retorno) do metodo original
  default String getStarShipsFallback(){
    return ERROR_MSG;
  }

}
