
import java.sql.*;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Select
 */
@WebServlet("/Select")
public class Select extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Select() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String rid=request.getParameter("rid");
			String money=request.getParameter("plan");
			String period="";
			if(money.length()<=2)
				period="daily";
			else if(money.length()==3)
				period="monthly";
			else if(money.length()==4)
				period="yearly";
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/employee", "root", "root");
				PreparedStatement ps = conn.prepareStatement("insert into plan values(?,?,?);");
				ps.setString(1, rid);
				ps.setString(2, money);
				ps.setString(3, period);
				int x = ps.executeUpdate();
				if (x > 0){
					System.out.println("Successfully Inserted1");
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
						session.setAttribute("org", rs.getString(7));
						response.sendRedirect("http://localhost:8080/MetaServer/home.jsp");
					}
				} else {
					System.out.println("Insert Failed");
				}
				conn.close();
			} catch (Exception e) {
				System.out.println(e);
			}
	}

}
