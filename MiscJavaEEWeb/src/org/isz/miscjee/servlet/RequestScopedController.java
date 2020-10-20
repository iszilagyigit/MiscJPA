package org.isz.miscjee.servlet;

import java.io.PrintWriter;
import java.util.Random;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.test.ejbs.StatelessEJBWithDependentField;

/**
 * Simple CDI Controller Example.
 * 
 * @author iszilagyi
 *
 */
@RequestScoped
public class RequestScopedController {

	private static final String CRLF = " \r\n";
	private static final Random random = new Random();
	
	@Inject
	private StatelessEJBWithDependentField aBean;

	/**
	 * Consecutive calls for an injected bean.
	 * @param writer output
	 */
	public void loopCalls(PrintWriter writer) {
		for (int i = 0; i <= 20; i++) {
			final String call1 = aBean.call1();
			final String call2 = aBean.call2();
			writer
			.append(i + " " + call1).append(CRLF)
			.append(i + " " + call2).append(CRLF);
			try {
				Thread.sleep(random.nextInt(100));
			} catch (InterruptedException e) {
				e.printStackTrace(writer);
			}
		}
	}
}
