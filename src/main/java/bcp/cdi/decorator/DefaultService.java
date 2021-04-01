package bcp.cdi.decorator;

import javax.enterprise.context.Dependent;

import lombok.extern.slf4j.Slf4j;

@Dependent
@Slf4j
public class DefaultService implements ServiceInterface {

  @Override
  public void doSomething() {
    log.debug("doSomething in DefaultService");
  }

  @Override
  public void doSomethingElse() {
    log.debug("doSomethingElse in DefaultService");
  }
  
}
