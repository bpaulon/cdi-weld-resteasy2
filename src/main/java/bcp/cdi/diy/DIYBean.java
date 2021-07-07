package bcp.cdi.diy;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class DIYBean {

  private MyService myService;
  
  public DIYBean() {
    myService = new MyService();
  }

  public DIYBean(MyService myService) {
    this.myService = myService;
  }
  
  public void doStuff() {
    myService.doStuff();
  }

  @Test
  public void test() {
    MyService myService = Mockito.mock(MyService.class);
    DIYBean bean = new DIYBean(myService);
    bean.doStuff();
    
    //... assert things
  }
  
}
