package bcp.cdi.events;

import static bcp.cdi.util.LogUtil.POSTCONSTRUCT_MSG;
import static bcp.cdi.util.LogUtil.identity;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Destroyed;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class StartupBean {

	public void init(@Observes @Initialized(ApplicationScoped.class) Object init) {
		log.debug("ApplicationScoped initialized:{}",  identity(init));
	}

	public void destroy(@Observes @Destroyed(ApplicationScoped.class) Object init) {
		log.debug("ApplicationScoped destroyed event {}", init);
	}
	
	@PostConstruct
	public void postConstruct() {
		log.debug(POSTCONSTRUCT_MSG, identity(this));
	}

}
