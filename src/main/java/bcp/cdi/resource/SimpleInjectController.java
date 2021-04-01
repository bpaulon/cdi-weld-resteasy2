package bcp.cdi.resource;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("simple-inject")
@ApplicationScoped
public class SimpleInjectController {
  
  @Inject
  private UserService userService;
  
  @GET
  public String callDependentScopedService() {
    userService.doSomething();
    return "DONE";
  }
}
