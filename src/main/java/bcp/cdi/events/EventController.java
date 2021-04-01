package bcp.cdi.events;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("event")
@ApplicationScoped
public class EventController {

  @Inject
  Event<SimpleEvent> event;
  
  @GET
  public String generateEvent() {
    this.event.fire(new SimpleEvent("id:12344"));
    
    return "DONE";
  }
}
