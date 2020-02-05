

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentUpdate
 */
@WebServlet("/StudentUpdate")
public class StudentUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		String updatedemail=request.getParameter("updatedemail");
		String class1=request.getParameter("class");
		String age=request.getParameter("age");
		System.out.println(email);
		System.out.println(updatedemail);
		System.out.println(class1);
		System.out.println(age);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/Student", "root", "root");
			PreparedStatement ps = conn.prepareStatement("UPDATE std SET email=(?),class=(?),age=(?) WHERE email=(?);");
			ps.setString(1, updatedemail);
			ps.setString(2, class1);
			ps.setString(3, age);
			ps.setString(4, email);
			int x = ps.executeUpdate();
			if (x > 0){
				System.out.println("Successfully Inserted");
			} else {
				System.out.println("Insert Failed");
			}
			conn.close();
			response.sendRedirect("http://localhost:8080/Student/main.jsp");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
