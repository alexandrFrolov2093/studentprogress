import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ItCoursesServlet", urlPatterns = "/it-courses")

public class ItCoursesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("<html>\n" +
                "<body>\n" +
                "<h2>It courses main!</h2>\n" +
                "</body>\n" +
                "</html>\n");
    }
}
