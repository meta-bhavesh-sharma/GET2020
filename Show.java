import java.sql.*;
import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Show
 */
@WebServlet("/Show")
public class Show extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Show() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String org=request.getParameter("org");
		ArrayList<String> name=new ArrayList<String>();
		ArrayList<String> email=new ArrayList<String>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/employee", "root", "root");
				Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery("select*from emp where org='"+org+"';");
				while(rs.next())
				{
					name.add(rs.getString(1));
					email.add(rs.getString(3));
				}
				System.out.println(org);
				System.out.println(name);
				System.out.println(email);
				conn.close();
				HttpSession session=request.getSession();
				session.setAttribute("namelist", name);
				session.setAttribute("emaillist", email);
				response.sendRedirect("list.jsp");
			} 	
		 catch (Exception e) {
			System.out.println(e);
		}
	}

}
