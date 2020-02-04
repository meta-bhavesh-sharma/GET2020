

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("empname");
		String gender=request.getParameter("gender");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String contact=request.getParameter("contact");
		String org=request.getParameter("org");
		System.out.println(org);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/employee", "root", "root");
			PreparedStatement ps = conn.prepareStatement("insert into emp (name,gender,email,password,contact,org) values(?,?,?,?,?,?);");
			ps.setString(1, name);
			ps.setString(2, gender);
			ps.setString(3, email);
			ps.setString(4, password);
			ps.setString(5, contact);
			ps.setString(6, org);
			int x = ps.executeUpdate();
			//String userId = ps.getGeneratedKeys().getString(1);
			if (x > 0){
				System.out.println("Successfully Inserted");
				RequestDispatcher dis=request.getRequestDispatcher("login.jsp");
				dis.forward(request,response);
				//response.setStatus(200, "User saved Successfully with registration Id "+ userId);
			} else {
				System.out.println("Insert Failed");
				//response.setStatus(500, "There was an error processing your request");
			}
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
