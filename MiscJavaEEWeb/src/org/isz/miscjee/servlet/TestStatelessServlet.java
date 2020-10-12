package org.isz.miscjee.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.test.ejbs.StatelessEJB;

/**
 * Test stateless EJB.
 * 
 * Servlet to demonstrate that Stateless EJB are really Stateless :-).
 * 
 * Already with a few parallel browser calls (when servlets served with different threads)
 * 
 * @author iszilagyi
 *
 */
@WebServlet("/TestStatelessServlet")
public class TestStatelessServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final String CRLF = " \r\n";
	private static final Random random = new Random();
	
	@Inject
	protected StatelessEJB statelessBean; 
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/plain");
		PrintWriter writer = resp.getWriter();
		writer
		.append("Served at: ").append(req.getContextPath()).append(CRLF);

		for (int i = 0; i <= 20; i++) {
			final String call1 = statelessBean.call1();
			final String call2 = statelessBean.call2();
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
