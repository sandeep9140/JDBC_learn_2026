import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet ("/hello")
public class HelloServlet1 extends HttpServlet {
    
    public void doGet(HttpServletRequest request,HttpServletResponse  response)
                throws ServletException, IOException{

                    response.setContentType("text/html");

                    String name =request.getParameter("name");
                    response.getWriter().println(
                        "<h1> Hello "+name+"!</h1>"
                    );
                }

    
}
