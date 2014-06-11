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
        String topping = req.getParameter("topping");
        int price1 = 0;
        int price2 = 2;
        int haitatu=1;
        if(title.equals("マリナーラ")==true) price1=450;
        if(title.equals("マルゲリータ")==true) price1=500;
        if(title.equals("クアトロフォルマッジ")==true) price1=550;
        if(title.equals("クアトロスタジオニ")==true) price1=600;
        if(title.equals("ボスカイオラ")==true) price1=650;
        if(title.equals("ビスマルク")==true) price1=700;
        if(title.equals("ペスカトーレ")==true) price1=750;
        if(title.equals("カプリチョーザ")==true) price1=800;
        
        if(topping.equals("チーズ")==true) price2=100;
        if(topping.equals("たまご")==true) price2=200;
        if(topping.equals("バジル")==true) price2=50;
        if(topping.equals("サラミ")==true) price2=100;
        int price = price1 + price2;
        String comment = req.getParameter("comment");
        Date date = Calendar.getInstance().getTime();
        LinkData data = new LinkData(title,price,comment,date,haitatu,name,topping);
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