package org.isz.miscjee.interceptor;

import java.io.Serializable;
import javax.annotation.Priority;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Interceptor für counter.
 *
 * @author Istvan Szilagyi
 */
@CounterIntercept
@Interceptor
@Priority(Interceptor.Priority.APPLICATION)
public class CounterInterceptor implements Serializable
{

	private static final long serialVersionUID = 1L;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CounterInterceptor.class.getName());

  /**
   * Example Logging.
   *
   * @param ctx Invocation context
   * @return Result from proceed
   * @throws Exception Exception
   */
  @AroundInvoke
  public Object counterLogging(final InvocationContext ctx) throws Exception  {
    final Class<?> aClass = ctx.getMethod().getDeclaringClass();
    final String methodName = ctx.getMethod().getName();
    if (LOGGER.isInfoEnabled())
    {
      LOGGER.info(String.format("CounterInterceptor: *** %s ***", aClass));
      LOGGER.info(String.format("CounterInterceptor - start %s ", methodName));
    }
    Object ret = ctx.proceed();
    if (LOGGER.isInfoEnabled())
    {
      LOGGER.info(String.format("CounterInterceptor - end %s ", methodName));
    }
    return ret;
  }
}
