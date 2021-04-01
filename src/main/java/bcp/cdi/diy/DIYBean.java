package bcp.cdi.diy;

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

}
