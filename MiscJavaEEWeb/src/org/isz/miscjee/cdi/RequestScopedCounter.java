package org.isz.miscjee.cdi;

import java.util.concurrent.atomic.AtomicLong;

import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * Example application scoped "POJO Bean".
 * 
 * @author iszilagyi
 *
 */
@RequestScoped
@Named("requestcnt")
public class RequestScopedCounter implements Counter {

	private AtomicLong count = new AtomicLong(0);

	@Override
	public long getCount() {
		return count.getAndIncrement();
	}

	@PreDestroy
	private void preDestroy() {
		System.out.println("RequestScopedCounter - preDestroy");
	}

	@PostConstruct
	private void postConstruct() {
		System.out.println("RequestScopedCounter - postConstruct");
	}
}
