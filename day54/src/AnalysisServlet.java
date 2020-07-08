import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AnalysisServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String s = req.getParameter("lm");
        String ret = "";
        if(s.equals("1")) {
            ret = Ana1.func();
        } else if(s.equals("2")) {
            ret = Ana2.func();
        } else if(s.equals("3")) {
            ret = Ana3.func();
        } else if(s.equals("4")) {
            ret = Ana4.func();
        } else if(s.equals("5")) {
            ret = Ana5.func();
        } else if(s.equals("6")) {
            ret = Ana6.func();
        }
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.println(ret);
    }


}
