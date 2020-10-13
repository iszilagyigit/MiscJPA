package org.isz.miscjee.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.ejb.EJB;
import javax.ejb.EJBLocalHome;
import javax.ejb.EJBLocalObject;
import javax.ejb.EJBObject;
import javax.ejb.RemoveException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.test.ejbs.StatefulEJB;
import org.test.ejbs.StatelessEJB;

/**
 * Test stateless EJB.
 * 
 * Servlet to demonstrate that Stateless EJB are really Stateless :-).
 * 
 * Already with a few parallel browser calls (when servlets served with different threads 
 *  - Ctrl + Reload button in chrome by selecting multiple tabs.)
 * 
 * @author iszilagyi
 *
 */
@WebServlet("/TestStatelessServlet")
public class TestStatelessServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String CRLF = " \r\n";
	
	@Inject
	protected RequestScopedController aController; 
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/plain");
		PrintWriter writer = resp.getWriter();
		writer
		.append("Served at: ").append(req.getContextPath()).append(CRLF);
		aController.loopCalls(writer);
	
		
	}
}
