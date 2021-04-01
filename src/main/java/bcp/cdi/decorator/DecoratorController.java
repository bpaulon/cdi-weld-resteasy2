package bcp.cdi.decorator;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("decorator")
@ApplicationScoped
public class DecoratorController {

  @Inject
  private ServiceInterface service;

  @GET
  public String callService() {
    service.doSomething();
    service.doSomethingElse();
    return "DONE";
  }
}
