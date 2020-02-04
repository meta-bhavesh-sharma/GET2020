import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		int rid=0;
		PrintWriter out = response.getWriter();
		try {
			int flag=0;
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/employee", "root", "root");
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select email,password,rid from emp;");
			while (rs.next()) {
				if (email.equals(rs.getString(1))
						&& password.equals(rs.getString(2))) {
					rid=rs.getInt(3);
					String str1 = Integer.toString(rid);
					System.out.println("hello1");
					ResultSet rs1=st.executeQuery("select * from plan where rid="+str1+";");
					System.out.println("hello2");
					while(rs1.next())
					{
						System.out.println("hello3");
						ResultSet rs2=st.executeQuery("select*from emp where Rid="+rid+";");
						HttpSession session=request.getSession();
						System.out.println("hello4");
						while(rs2.next())
						{
							System.out.println("hello5");
							session.setAttribute("name", rs2.getString(1));
							session.setAttribute("gender", rs2.getString(2));
							session.setAttribute("email", rs2.getString(3));
							session.setAttribute("password", rs2.getString(4));
							session.setAttribute("contact", rs2.getString(5));
							session.setAttribute("Rid", rs2.getString(6));
							session.setAttribute("org", rs2.getString(7));
							break;
						}
						response.sendRedirect("http://localhost:8080/MetaServer/home.jsp");
						System.out.println("hello6");
						break;
					}
					rs1=st.executeQuery("select * from veichle where rid="+str1+";");
					System.out.println("hello7");
					while(rs1.next())
					{
						System.out.println("hello8");
						ResultSet rs2=st.executeQuery("select*from veichle where Rid="+str1+";");
						HttpSession session=request.getSession();
						while(rs2.next())
						{
							session.setAttribute("Rid", rs2.getString(1));
							session.setAttribute("vehtype", rs2.getString(3));
							break;
						}
						response.sendRedirect("http://localhost:8080/MetaServer/plan.jsp");
						break;
					}
					HttpSession session=request.getSession();
					session.setAttribute("Id", email);
					out.println("<!DOCTYPE html><html><head> <link href='style.css'rel='stylesheet' type='text/css'><title>Epmloyee </title> <script src='register.js'> </script></head><body><form id='vehicle' method='POST' action='plan' ><h2>Employee  vichle Registration form</h2><input name='Rid' id='Rid' type='text' value="+rid+" placeholder='Registration id' readonly></input><br><br><input name='vname' id='vname' type='text' placeholder='Veichle Name' required></input><br><div style='font-size: 20px;color:darkseagreen'>Type<label><input id='check1' type='radio'  name='type' value='cycle'></input>Cycle</label><label><input id='check2' type='radio'  name='type' value='bike'></input>Moter Bike</label><label><input id='check3' type='radio'  name='type' value='car'></label></input>Four Wheeler<br></label></div><input name='vnum' id='vnum' type='text' placeholder='vichle Number'></input><br><textarea name='identify' placeholder='Identifcation'></textarea><br><input type='submit' value='Go' onclick='purchase();'></form></body></html>");
					flag=1;
					break;
				}
			}
			if(flag==0)
			{
			response.setContentType("text/html");      
		       PrintWriter pwriter = response.getWriter();                  
		          pwriter.print("<div styl='font-size=20px'>User name or password is incorrect!</div>");          
		          RequestDispatcher dis=request.getRequestDispatcher("login.jsp");          
		          dis.include(request, response);
			}
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
