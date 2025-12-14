package net.buscacio;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;


@Path("/unipds")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
public class UnipdsResource {
  private int counter = 0;

  @GET
  public int getCounter() {
    return counter;
  }

  @POST
  public void incrementCounter() {
    counter++;
  }

  @PUT
  public int updateCounter(int value) {
    return this.counter = value;
  }

  @DELETE
  public void deleteCounter() {
    counter--;
  }
}
