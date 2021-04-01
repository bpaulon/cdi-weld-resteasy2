package bcp.cdi.conf;

import static bcp.cdi.util.LogUtil.identity;
import static bcp.cdi.util.LogUtil.logDestroyEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.Produces;

import bcp.cdi.resource.UserService;
import bcp.cdi.util.LogUtil;
import lombok.extern.slf4j.Slf4j;

@ApplicationScoped
@Slf4j
public class ApplicationResources {

	@Produces
	@RequestProduced
	public UserService createUserService(Instance<UserService> instance) {
		UserService us = instance.select(UserService.class).get();
		log.debug(LogUtil.CREATED_MSG, identity(us));

		return us;
	}

	public void disposeUserService(@RequestProduced @Disposes UserService us) {
		logDestroyEvent(this, us);
	}

}
