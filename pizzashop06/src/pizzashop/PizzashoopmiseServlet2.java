package pizzashop;
import java.io.*;
import java.util.*;
import javax.jdo.*;
import javax.servlet.http.*;
 
@SuppressWarnings("serial")
public class PizzashoopmiseServlet2 extends HttpServlet {
    public void doGet(HttpServletRequest req,
            HttpServletResponse resp)
            throws IOException {
        PersistenceManagerFactory factory = PMF.get();
        PersistenceManager manager = factory.getPersistenceManager();
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        req.setCharacterEncoding("utf-8");
        String param1 = req.getParameter("id");
        PrintWriter out = resp.getWriter();
        List<pizza.LinkdataHaitatu> list = null;
        if (param1 == null || param1 ==""){
            String query = "select from " + pizza.LinkdataHaitatu.class.getName();
            try {
                list = (List<pizza.LinkdataHaitatu>)manager.newQuery(query).execute();
            } catch(JDOObjectNotFoundException e){}
        } else {
            try {
                pizza.LinkdataHaitatu data = (pizza.LinkdataHaitatu)manager.getObjectById(pizza.LinkdataHaitatu.class,Long.parseLong(param1));
                list = new ArrayList();
                list.add(data);
            } catch(JDOObjectNotFoundException e){}
        }
        String res = "[";
        if (list != null){
            for(pizza.LinkdataHaitatu data:list){
                res += "{id:" + data.getId() + ",price:'" + data.getPrice() + "',title:'" +
                    data.getTitle() + "',date:'" + data.getDatetime() +
                    "',comment:'" + data.getComment() + "'},";
            }
        }
        res += "]";
        out.println(res);
        manager.close();
    }
}