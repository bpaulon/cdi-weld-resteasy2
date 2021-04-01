package bcp.cdi.diy;

import javax.inject.Inject;

public class CDIBean {
  
  @Inject
  private MyService myService;
  
  @Inject
  public CDIBean(MyService myService) {
    this.myService = myService;
  }
  
  @Inject
  public void setMyService(MyService myService) {
    this.myService = myService;
  }
  
  public void doStuff() {
    myService.doStuff();
  }
}
