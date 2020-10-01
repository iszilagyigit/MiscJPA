package org.isz.miscjee.servlet;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.isz.miscjee.cdi.Counter;

/**
 * Servlet example for CDI, same interface with different scopes.
 *
 * @author Istvan Szilagyi
 */
@WebServlet("/TestCDIServlet")
public class TestCDIServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String CRLF = " \r\n";

	@Inject
	@Named("sessioncnt")
	private Counter sessionCounter;
		
	@Inject
	@Named("applcnt")
	private Counter applCounter;

	@Inject
	@Named("requestcnt")
	private Counter requestCounter;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/plain");
		response.getWriter()
		.append("Served at: ").append(request.getContextPath()).append(CRLF)
		.append(" RequestCounter: ").append(requestCounter.getName()).append(" ").append(Long.toString(requestCounter.getCount())).append(CRLF)
		.append(" SessionCounter: ").append(sessionCounter.getName()).append(" ").append(Long.toString(sessionCounter.getCount())).append(CRLF)
		.append(" ApplicationCounter: ").append(applCounter.getName()).append(" ").append(Long.toString(applCounter.getCount())).append(CRLF);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		doGet(request, response);
	}
}
