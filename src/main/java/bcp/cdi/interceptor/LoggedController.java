package bcp.cdi.interceptor;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("log")
//@ApplicationScoped // one interceptor for this controller (interceptors are depedent)
@RequestScoped // for each request it creates a new Log interceptor
@Logged
public class LoggedController {
  
  @GET
  public String callLoggedMethod() {
    return "DONE";
  }
  
}
