package bcp.cdi.resteasy;

import javax.enterprise.context.RequestScoped;

import org.jboss.weld.junit5.auto.ActivateScopes;
import org.jboss.weld.junit5.auto.AddBeanClasses;
import org.jboss.weld.junit5.auto.EnableAutoWeld;
import org.junit.jupiter.api.Test;

import bcp.cdi.resource.UserService;

@EnableAutoWeld
@ActivateScopes({ RequestScoped.class })
@AddBeanClasses(UserService.class)
public class UserServiceTest {

  @Test
  public void testService(UserService userService) {
    userService.doSomething();
  }

  @Test
  public void test1() {
    System.out.println(0x3F);
    System.out.println(64 & 0x3F);
  }
}
