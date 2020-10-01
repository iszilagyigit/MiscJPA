package org.isz.miscjee.cdi;

import java.util.concurrent.atomic.AtomicLong;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
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
@ApplicationScoped
@Named("applcnt")
@CounterIntercept
public class ApplicationScopedCounter implements Counter  {

	private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationScopedCounter.class.getName());

	private final AtomicLong count = new AtomicLong(0);

	@Override
	public long getCount() {
		return count.getAndIncrement();
	}

	@PreDestroy
	private void preDestroy() {
		LOGGER.info("ApplicationScopedCounter - preDestroy");
	}

	@PostConstruct
	private void postConstruct() {
		LOGGER.info("ApplicationScopedCounter - postConstruct");
	}
}
