

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentSearch
 */
@WebServlet("/StudentSearch")
public class StudentSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentSearch() {
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
		String fn=request.getParameter("fname");
		String ln=request.getParameter("lname");
		PrintWriter out = response.getWriter();
		out.print("hello");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/Student", "root", "root");
			Statement st = conn.createStatement();
			String s="select *from std where first_name='"+fn+"' AND last_name='"+ln+"';";
			System.out.println(s);
			ResultSet rs = st.executeQuery(s);
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
	    	out.println("<br>");
	    	out.print("First Name	");
	    	out.print("Last Name	");
	    	out.print("Father Name	");
	    	out.print("Email		");
	    	out.print("Class		");
	    	out.print("Age			");
		    for(int i=0;i<fstname.size();i++)
		    {
		    	out.println("<br>");
		    	out.print(fstname.get(i)+"		");
		    	out.print(lstname.get(i)+"		");
		    	out.print(fname.get(i)+"		");
		    	out.print(email.get(i)+"		");
		    	out.print(class1.get(i)+"		");
		    	out.print(age.get(i)  + "		");
		    }
		    out.println("<a href='http://localhost:8080/Student/main.html'></a>"); 
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
