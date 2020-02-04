import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class VehicleRegister
 */
@WebServlet("/VehicleRegister")
public class VehicleRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VehicleRegister() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rid=request.getParameter("Rid");
		String vname=request.getParameter("vname");;
		String type =request.getParameter("type");;
		String vnum =request.getParameter("vnum");
		String identify=request.getParameter("identify") ;
		HttpSession session=request.getSession();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/employee", "root", "root");
			PreparedStatement ps = conn.prepareStatement("insert into veichle values(?,?,?,?,?);");
			ps.setString(1, rid);
			ps.setString(2, vname);
			ps.setString(3, type);
			ps.setString(4, vnum);
			ps.setString(5, identify);
			int x = ps.executeUpdate();
			if (x > 0)
			{
				System.out.println("Successfully Inserted");
				
				session.setAttribute("vehtype", type);
				session.setAttribute("Rid", rid);
				//RequestDispatcher dis=request.getRequestDispatcher("plan.jsp");
				//dis.forward(request,response);
				response.sendRedirect("plan.jsp");
			}
			else {
				System.out.println("Insert Failed");
			}
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
