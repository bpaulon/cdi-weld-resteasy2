package bcp.cdi.interceptor;

import static bcp.cdi.util.LogUtil.*;

import java.util.Arrays;

import javax.annotation.PreDestroy;
import javax.annotation.Priority;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import lombok.extern.slf4j.Slf4j;

/** 
 * Interceptor which logs the parameters and the result. Interceptors have 
 * Dependent scope 
 */

@Logged
@Interceptor
@Priority(Interceptor.Priority.APPLICATION)
@Slf4j
public class LogInterceptor {

	public LogInterceptor() {
		logConstructorEvent(log, this);
	}

	@AroundInvoke
	public Object logMethod(InvocationContext ctx) throws Exception {
		log.debug("Intercepted START obj:{} method:{} with parameters: {}", identity(ctx.getTarget()), ctx.getMethod(),
		        Arrays.toString(ctx.getParameters()));
		// can alter parameters ctx.setParameters(params);
		Object result = ctx.proceed();
		log.debug("Intercepted END result: {}", result);
		return result;
	}

	//...
	
	@PreDestroy
	public void destroy() {
		logDestroyEvent(log, this);
	}
}