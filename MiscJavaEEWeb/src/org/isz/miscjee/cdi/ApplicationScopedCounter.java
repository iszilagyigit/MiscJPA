package org.isz.miscjee.cdi;

import java.util.concurrent.atomic.AtomicLong;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import org.isz.miscjee.interceptor.CounterIntercept;

/**
 * Example application scoped "POJO Bean".
 * 
 * @author iszilagyi
 *
 */
@ApplicationScoped
@Named("applcnt")
@CounterIntercept
public class ApplicationScopedCounter implements Counter  {

	private AtomicLong count = new AtomicLong(0);

	@Override
	public long getCount() {
		return count.getAndIncrement();
	}

	@PreDestroy
	private void preDestroy() {
		System.out.println("ApplicationScopedCounter - preDestroy");
	}

	@PostConstruct
	private void postConstruct() {
		System.out.println("ApplicationScopedCounter - postConstruct");
	}
}
