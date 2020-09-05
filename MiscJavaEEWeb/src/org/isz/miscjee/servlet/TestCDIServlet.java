package org.isz.miscjee.servlet;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter()
		.append("Served at: " + request.getContextPath() + "\r\n")
		.append(" RequestCounter: " + requestCounter.getName() + " " + requestCounter.getCount()+" \r\n")
		.append(" SessionCounter: " + sessionCounter.getName() + " " + sessionCounter.getCount()+" \r\n")
		.append(" ApplicationCounter: " + applCounter.getName() + " " + applCounter.getCount()+" \r\n");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
