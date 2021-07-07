package bcp.cdi.resource;

import static bcp.cdi.util.LogUtil.CONSTRUCTOR_MSG;
import static bcp.cdi.util.LogUtil.identity;
import static bcp.cdi.util.LogUtil.logConstructorEvent;

import java.time.LocalDateTime;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import bcp.cdi.conf.RequestProduced;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Sample controller which uses the same service bean with different scopes
 */
@Path("users")
@ApplicationScoped
@NoArgsConstructor
@Slf4j
public class UserController {

	@Inject
	@RequestProduced
	// request scoped bean
	private UserService usRequest;

	// this will be injected in the constructor. Dependent beans 
	// aren't tied to a context. As far as CDI is concerned after being 
	// injected they are ordinary (strongly reachable) Java objects.
	private UserService usDependent;

	@Inject
	public UserController(UserService us) {
		this.usDependent = us;
		log.debug(CONSTRUCTOR_MSG, identity(this));
		logConstructorEvent(log, this);
	}

	/**
	 * The UserService injected bean has this scope (ApplicationScoped)
   * @return the response
	 */
	@Path("/dependent")
	@GET
	public String callDependentScopedService() {
		usDependent.doSomething();
		return "DONE " + LocalDateTime.now();
	}

	/**
	 * The UserService injected bean has request scope (RequestScoped)
	 * even if this controller is ApplicationScoped
	 * 
	 * @return the response
	 */
	@Path("/request")
	@GET
	public String callRequestScopedService() {
		usRequest.doSomething();
		return "DONE " + LocalDateTime.now();
	}
	
}
