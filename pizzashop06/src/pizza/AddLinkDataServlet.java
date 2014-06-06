package pizza;
import java.io.IOException;
import java.net.URL;
import java.util.*;
 
import javax.jdo.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
 
public class AddLinkDataServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    @Override
    protected void doGet(HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/plain");
        resp.getWriter().println("no url...");
    }
 
    @Override
    protected void doPost(HttpServletRequest req,HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String title = req.getParameter("pizza");
        String name = req.getParameter("name");
        int price = 0;
        int haitatu=1;
        if(title.equals("マリナーラ")==true) price=450;
        if(title.equals("マルゲリータ")==true) price=500;
        if(title.equals("クアトロフォルマッジ")==true) price=550;
        if(title.equals("クアトロスタジオニ")==true) price=600;
        if(title.equals("ボスカイオラ")==true) price=650;
        if(title.equals("ビスマルク")==true) price=700;
        if(title.equals("ペスカトーレ")==true) price=750;
        if(title.equals("カプリチョーザ")==true) price=800;
        String comment = req.getParameter("comment");
        Date date = Calendar.getInstance().getTime();
        LinkData data = new LinkData(title,price,comment,date,haitatu,name);
        PersistenceManagerFactory factory = PMF.get();
        PersistenceManager manager = factory.getPersistenceManager();
        try {
            manager.makePersistent(data);
        } finally {
            manager.close();
        }
        resp.sendRedirect("/confirm.html");
    }
}