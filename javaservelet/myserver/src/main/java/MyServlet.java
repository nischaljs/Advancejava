import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/hello")
public class MyServlet extends HttpServlet {

    // 1. INITIALIZATION: Runs only once when the server starts or first request comes
    @Override
    public void init() throws ServletException {
        // This is where you open Database connections or load configuration files
        System.out.println("Servlet is starting: init() method called.");
    }

    // 2. SERVICE: Runs every time a user hits the URL
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    resp.setContentType("text/html");
    var out = resp.getWriter();

    out.println("<html>");
    out.println("<head><title>Registration Form</title></head>");
    out.println("<body>");
    out.println("<h2>Student Details Form</h2>");
    
    // The action="hello" points back to this servlet
    // The method="POST" means it will go to the doPost() method
    out.println("<form action='hello' method='POST'>");
    
    out.println("Name: <input type='text' name='txtName'><br><br>");
    out.println("Age: <input type='number' name='txtAge'><br><br>");
    out.println("Address: <input type='text' name='txtAddress'><br><br>");
    out.println("Contact: <input type='text' name='txtContact'><br><br>");
    
    out.println("<input type='submit' value='Submit Details'>");
    out.println("</form>");
    
    out.println("</body>");
    out.println("</html>");
}

    // 3. DESTRUCTION: Runs only once when the server is stopping or app is undeployed
    @Override
    public void destroy() {
        // This is where you close Database connections to prevent memory leaks
        System.out.println("Servlet is stopping: destroy() method called.");
    }
}