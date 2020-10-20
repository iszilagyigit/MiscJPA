package org.isz.miscjee.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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
	private StatelessService aService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		resp.setContentType("text/plain");
		try
		{
			final PrintWriter	writer = resp.getWriter();
			writer.append("Served at: ").append(req.getContextPath()).append(CRLF);
			aService.loopCalls(writer);
		} catch (IOException pE)
		{
			pE.printStackTrace();
		}
	}
}
