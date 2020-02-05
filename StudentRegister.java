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

@WebServlet("/StudentRegister")
public class StudentRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public StudentRegister() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fstname=request.getParameter("fstname");
		String lstname=request.getParameter("lstname");
		String fname=request.getParameter("fname");
		String email=request.getParameter("email");
		String class1=request.getParameter("class");
		String age=request.getParameter("age");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/Student", "root", "root");
			PreparedStatement ps = conn.prepareStatement("insert into std values(?,?,?,?,?,?);", PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, fstname);
			ps.setString(2, lstname);
			ps.setString(3, fname);
			ps.setString(4, email);
			ps.setString(5, class1);
			ps.setString(6, age);
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
