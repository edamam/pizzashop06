package pizzashop;

import java.io.IOException;
import java.util.*;

import javax.jdo.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import pizza.LinkData;
import pizza.PMF;

public class LoginServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("no url...");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String password = req.getParameter("password");
		PersistenceManagerFactory factory = PMF.get();
		if(password.equals("test")==true)
		resp.sendRedirect("/index2.html");
		else
			resp.sendRedirect("/loginfailed2.html");
	}
}
