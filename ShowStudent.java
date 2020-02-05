
import java.sql.*;
import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowStudent
 */
@WebServlet("/ShowStudent")
public class ShowStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowStudent() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<String> fstname =new ArrayList<String>();
		ArrayList<String> lstname =new ArrayList<String>();
		ArrayList<String> fname =new ArrayList<String>();
		ArrayList<String> email =new ArrayList<String>();
		ArrayList<String> class1 =new ArrayList<String>();
		ArrayList<String> age =new ArrayList<String>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/Student", "root", "root");
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select *from std");
			while(rs.next())
			{
				fstname.add(rs.getString(1));
				lstname.add(rs.getString(2));
				fname.add(rs.getString(3));
				email.add(rs.getString(4));
				class1.add(rs.getString(5));
				age.add(rs.getString(6));
			}
			conn.close();
			response.setContentType("text/html"); 
		    PrintWriter out = response.getWriter();
		    out.println("<link href='style.css' rel='stylesheet' type='text/css'>");
		    out.println("<table>");
		    out.println("<tr>");
		    out.println("<td>");out.print("First Name	");out.println("</td>");
	    	out.println("<td>");out.print("Last Name	");out.println("</td>");
	    	out.println("<td>");out.print("Father Name	");out.println("</td>");
	    	out.println("<td>");out.print("Email		");out.println("</td>");
	    	out.println("<td>");out.print("Class		");out.println("</td>");
	    	out.println("<td>");out.print("Age			");out.println("</td>");
	    	out.println("</tr>");
		    for(int i=0;i<fstname.size();i++)
		    {
		    	out.println("<tr>");
		    	out.println("<td>");out.print(fstname.get(i)+"		");out.println("</td>");
		    	out.println("<td>");out.print(lstname.get(i)+"		");out.println("</td>");
		    	out.println("<td>");out.print(fname.get(i)+"		");out.println("</td>");
		    	out.println("<td>");out.print(email.get(i)+"		");out.println("</td>");
		    	out.println("<td>");out.print(class1.get(i)+"		");out.println("</td>");
		    	out.println("<td>");out.print(age.get(i)  + "		");out.println("</td>");
		    	out.println("<td>");out.println("<form method='post' action='update.jsp'><input id='update' value='update' type='submit'><input name='email' value='"+email.get(i)+"' type='hidden'></form>");out.println("</td>");
		    	out.println("</tr>");
		    }
		    out.println("<table>");
		    out.println("<a href='http://localhost:8080/Student/main.html'></a>"); 
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
