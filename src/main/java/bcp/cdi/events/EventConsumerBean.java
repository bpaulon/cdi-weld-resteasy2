package bcp.cdi.events;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ApplicationScoped
public class EventConsumerBean {

  public void listenToSimpleEvents(@Observes SimpleEvent simpleEvent) {
    log.info("Received event {}", simpleEvent.getId());
  }
}
