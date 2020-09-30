package org.isz.miscjee.interceptor;

import java.io.Serializable;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 * Interceptor für counter.
 *
 * @author Istvan Szilagyi
 */
public class CounterInterceptor implements Serializable
{

  @AroundInvoke
  public Object counterLogging(final InvocationContext ctx) throws Exception  {
    final Class<?> aClass = ctx.getMethod().getDeclaringClass();
    final String methodName = ctx.getMethod().getName();
    System.out.println("CounterInterceptor: *** "   + aClass + " ***");
    System.out.println("CounterInterceptor - start " + methodName + " ");
    Object ret = ctx.proceed();
    System.out.println("CounterInterceptor - end " + methodName + " ");
    return ret;
  }
}
