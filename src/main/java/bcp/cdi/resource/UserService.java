package bcp.cdi.resource;

import static bcp.cdi.util.LogUtil.CONSTRUCTOR_MSG;
import static bcp.cdi.util.LogUtil.identity;

import javax.enterprise.context.Dependent;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Dependent
public class UserService {

	public UserService() {
		log.debug(CONSTRUCTOR_MSG, identity(this));
	}

	public void doSomething() {
		log.debug("doSomething called: {}", identity(this));
	}

}
