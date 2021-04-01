package bcp.cdi.decorator;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

import lombok.extern.slf4j.Slf4j;

@Decorator
@Slf4j
public abstract class DecoratedService implements ServiceInterface {

  private ServiceInterface service;

  @Inject
  public DecoratedService(@Delegate ServiceInterface service) {
    this.service = service;
  }
  
  @Override
  public void doSomething() {
    log.debug("doSomething in DecoratedService");
    service.doSomething();
  }

}
