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
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.getWriter()
		.append("Served at: " + request.getContextPath() + "\r\n")
		.append(" RequestCounter: " + requestCounter.getName() + " " + requestCounter.getCount() + CRLF)
		.append(" SessionCounter: " + sessionCounter.getName() + " " + sessionCounter.getCount() + CRLF)
		.append(" ApplicationCounter: " + applCounter.getName() + " " + applCounter.getCount() + CRLF);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		doGet(request, response);
	}
}
