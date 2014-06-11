package pizza;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import javax.jdo.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
 
public class HaitatuServlet extends HttpServlet {
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
        String title = req.getParameter("pizza");
        int haitatu =Integer.parseInt(req.getParameter("haitatu"));
        int price = Integer.parseInt(req.getParameter("price"));
        String comment = req.getParameter("comment");
        String name = req.getParameter("name");
        String topping = req.getParameter("topping");
        Date date = Calendar.getInstance().getTime();
        LinkData data = new LinkData(title,price,comment,date,1,name,topping);
        PersistenceManagerFactory factory = PMF.get();
        PersistenceManager manager = factory.getPersistenceManager();
        try {
            manager.makePersistent(data);
        } finally {
            manager.close();
        }
        resp.sendRedirect("/indexmodoki.html");
    }
    //confirmからデータが送られてこないので、なんかしてhaitatuを1にする
    /*
       PersistenceManagerFactory factory = PMF.get();
       PersistenceManager manager = factory.getPersistenceManager();
       LinkData data = (LinkData)manager.getObjectById(LinkData.class,id);
       data.setTitle(title);
       data.setComment(comment);
       manager.close();
       resp.sendRedirect("/index.html");
   }
    */
}