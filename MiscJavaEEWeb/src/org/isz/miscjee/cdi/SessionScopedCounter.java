package org.isz.miscjee.cdi;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.SessionScoped;
// import javax.inject.Singleton  -- NPE;
import javax.inject.Named;
import javax.interceptor.Interceptors;
import org.isz.miscjee.interceptor.CounterInterceptor;

/**
 * Example session scoped "POJO Bean".
 * 
 * @implNote
 * Implements Serializable otherwise:
 * WELD-000072: Bean declaring a passivating scope must be passivation capable. (implements serializable)
 * 
 * @author iszilagyi
 *
 */
@SessionScoped
@Named("sessioncnt")
public class SessionScopedCounter implements Counter, Serializable {

	private static final long serialVersionUID = 1L;
	
	private AtomicLong count = new AtomicLong(0);

	@Interceptors(CounterInterceptor.class)
	@Override
	public long getCount() {
		return count.getAndIncrement();
	}

	@PreDestroy
	private void preDestroy() {
		System.out.println("SessionScopedCounter - preDestroy");
	}

	@PostConstruct
	private void postConstruct() {
		System.out.println("SessionScopedCounter - postConstruct");
	}
}
