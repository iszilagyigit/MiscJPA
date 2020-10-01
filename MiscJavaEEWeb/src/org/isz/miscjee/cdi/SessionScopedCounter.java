package org.isz.miscjee.cdi;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.isz.miscjee.interceptor.CounterIntercept;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Example session scoped "POJO Bean".
 * 
 * @implNote
 * Implements Serializable otherwise:
 * WELD-000072: Bean declaring a passivating scope must be passivation capable. (implements serializable)
 * NullPointerException When bean is import javax.inject.Singleton  -- NPE;
 *
 * @author Istvan Szilagyi
 *
 */
@SessionScoped
@Named("sessioncnt")
public class SessionScopedCounter implements Counter, Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LoggerFactory.getLogger(SessionScopedCounter.class.getName());

	private final AtomicLong count = new AtomicLong(0);

	@CounterIntercept
	@Override
	public long getCount() {
		return count.getAndIncrement();
	}

	@PreDestroy
	private void preDestroy() {
		LOGGER.info("SessionScopedCounter - preDestroy");
	}

	@PostConstruct
	private void postConstruct() {
		LOGGER.info("SessionScopedCounter - postConstruct");
	}
}
