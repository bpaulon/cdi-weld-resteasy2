package bcp.cdi.lifecycle;

import static bcp.cdi.util.LogUtil.identity;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestScoped
@Path("lifecycle")
public class ManagedController {
  
  @GET
  public String doSomethingInRequestScope() {
    return "DONE";
  }
  
  @PostConstruct
  public void postConstruct() {
    log.debug("PostConstruct {}", identity(this));
  }
  
  @PreDestroy
  public void destroy() {
    log.debug("PreDestroy {}", identity(this));
  }
}
