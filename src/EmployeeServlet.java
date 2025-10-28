import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class EmployeeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String empId = request.getParameter("empId");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/testdb", "root", "abc123");

            Statement stmt = con.createStatement();
            ResultSet rs;

            if (empId != null && !empId.isEmpty()) {
                rs = stmt.executeQuery("SELECT * FROM Employee WHERE EmpID=" + empId);
            } else {
                rs = stmt.executeQuery("SELECT * FROM Employee");
            }

            out.println("<h2>Employee Records</h2>");
            out.println("<table border='1'><tr><th>EmpID</th><th>Name</th><th>Salary</th></tr>");

            boolean found = false;
            while (rs.next()) {
                found = true;
                out.println("<tr><td>" + rs.getInt("EmpID") + "</td><td>" +
                        rs.getString("Name") + "</td><td>" + rs.getDouble("Salary") + "</td></tr>");
            }
            out.println("</table>");

            if (!found) {
                out.println("<p>No employee found with ID: " + empId + "</p>");
            }

            con.close();

        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
        }
        out.close();
    }
}
