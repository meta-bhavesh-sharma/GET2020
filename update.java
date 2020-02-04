import java.sql.*;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class update
 */
@WebServlet("/update")
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public update() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("empname");
		String email=request.getParameter("email");
		String contact=request.getParameter("contact");
		String rid=request.getParameter("rid");
		System.out.println(name);
		System.out.println(email);
		System.out.println(contact);
		int id = Integer.parseInt(rid);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/employee", "root", "root");
			PreparedStatement ps = conn.prepareStatement("update emp set name=?, email=?, contact=? where Rid=?;");
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, contact);
			ps.setInt(4, id);
			int x = ps.executeUpdate();
			//String userId = ps.getGeneratedKeys().getString(1);
			if (x > 0){
				System.out.println("Successfully Inserted");
				Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery("select*from emp where Rid="+rid+";");
				HttpSession session=request.getSession();
				while(rs.next())
				{
					session.setAttribute("name", rs.getString(1));
					session.setAttribute("gender", rs.getString(2));
					session.setAttribute("email", rs.getString(3));
					session.setAttribute("password", rs.getString(4));
					session.setAttribute("contact", rs.getString(5));
					session.setAttribute("Rid", rs.getString(6));
					response.sendRedirect("http://localhost:8080/MetaServer/home.jsp");
				}
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
