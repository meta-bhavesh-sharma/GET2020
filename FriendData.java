

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class FriendData
 */
@WebServlet("/FriendData")
public class FriendData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FriendData() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("friendsList");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/employee", "root", "root");
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("select*from emp where email='"+email+"';");
		HttpSession session=request.getSession();
		while(rs.next())
		{
			session.setAttribute("namef", rs.getString(1));
			session.setAttribute("genderf", rs.getString(2));
			session.setAttribute("emailf", rs.getString(3));
			session.setAttribute("passwordf", rs.getString(4));
			session.setAttribute("contactf", rs.getString(5));
			session.setAttribute("Ridf", rs.getString(6));
			session.setAttribute("orgf", rs.getString(7));
			response.sendRedirect("http://localhost:8080/MetaServer/fdata.jsp");
		}
		conn.close();
	}
		catch(Exception e)
		{
			e.getMessage();
		}
	}

}
