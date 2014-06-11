package pizza;

import java.io.IOException;
import java.util.*;

import javax.jdo.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class EditLinkDataServlet2 extends HttpServlet {
   private static final long serialVersionUID = 1L;

   @Override
   protected void doGet(HttpServletRequest req,
           HttpServletResponse resp)
           throws ServletException, IOException {
       resp.setContentType("text/plain");
       resp.getWriter().println("no url...");
   }

   @Override
   protected void doPost(HttpServletRequest req,
           HttpServletResponse resp)
           throws ServletException, IOException {
       req.setCharacterEncoding("UTF-8");
       long id = Long.parseLong(req.getParameter("id"));
       String haitatu = req.getParameter("");
       String title = req.getParameter("title");
       String topping = req.getParameter("topping");
       String comment = req.getParameter("comment");
       PersistenceManagerFactory factory = PMF.get();
       PersistenceManager manager = factory.getPersistenceManager();
       LinkData data = (LinkData)manager.getObjectById(LinkData.class,id);
       data.setTitle(title);
       data.setComment(comment);
       manager.close();
       resp.sendRedirect("/index2.html");
   }
}