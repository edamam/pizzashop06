package pizzashop;

import java.io.IOException;
import java.util.*;

import javax.jdo.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import pizza.LinkData;
import pizza.PMF;

public class EditLinkDataServlet2 extends HttpServlet {
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
		String title = req.getParameter("title");
		String comment = req.getParameter("comment");
		//増やした
		String name = req.getParameter("name");
		int price = Integer.parseInt(req.getParameter("price"));
        Date datetime = Calendar.getInstance().getTime();
		LinkData2 data = new LinkData2(title,price,comment);
//		LinkData2 data = new LinkData2(title,price,comment,name);
		PersistenceManagerFactory factory = PMF.get();
		PersistenceManager manager = factory.getPersistenceManager();

	    long id = Long.parseLong(req.getParameter("id"));
	    pizza.LinkData data2 = (pizza.LinkData)manager.getObjectById(pizza.LinkData.class,id);
	    
		try {
			manager.makePersistent(data);
		    manager.deletePersistent(data2);
		} finally {
			manager.close();
		}
		resp.sendRedirect("/confirm2.html");
	}
}