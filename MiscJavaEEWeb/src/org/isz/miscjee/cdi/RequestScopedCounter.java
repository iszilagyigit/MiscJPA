package org.isz.miscjee.cdi;

import java.util.concurrent.atomic.AtomicLong;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import org.isz.miscjee.interceptor.CounterIntercept;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Example application scoped "POJO Bean".
 * 
 * @author iszilagyi
 *
 */
@RequestScoped
@Named("requestcnt")
@CounterIntercept
public class RequestScopedCounter implements Counter {

	private static final Logger LOGGER = LoggerFactory.getLogger(RequestScopedCounter.class.getName());
	private final AtomicLong count = new AtomicLong(0);

	@Override
	public long getCount() {
		return count.getAndIncrement();
	}

	@PreDestroy
	private void preDestroy() {
		LOGGER.info("RequestScopedCounter - preDestroy");
	}

	@PostConstruct
	private void postConstruct() {
		LOGGER.info("RequestScopedCounter - postConstruct");
	}
}
