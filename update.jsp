<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="style.css" rel="stylesheet" type="text/css">
<title>Student</title>
</head>
<%
String fstname ="";
String lstname ="";
String fname ="";
String email ="";
String class1 ="";
String age ="";
try {
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/Student", "root", "root");
	Statement st = conn.createStatement();
	ResultSet rs = st.executeQuery("select *from std where email='"+request.getParameter("email")+"';");
	while(rs.next())
	{
		fstname=rs.getString(1);
		lstname=rs.getString(2);
		fname=rs.getString(3);
		email=rs.getString(4);
		class1=rs.getString(5);
		age=rs.getString(6);
	}
}
	 catch (Exception e) {
			System.out.println(e);
		}
%>
<body>
	<h1>Student Details Update</h1>
	<div>
	<form id="UpdateStudent" method="post" action="StudentUpdate">
		<h2>Update Student</h2>
		<br><input id="fstname" name="fstname" type="text" placeholder="First Name" value='<%=fstname %>' readonly></input><br>
        <br><input id="lstname" name="lstname" type="text" placeholder="Last Name" value='<%=lstname %>' readonly></input><br>
        <br><input id="fname" name="fname" type="text" placeholder="Father Name" value='<%=fname %>' readonly></input><br>
		<br> <input name="email" id="email" type="hidden" placeholder="email"value="<%=(String)request.getParameter("email")%>"></input><br>
		<input name="updatedemail" id="Updatedemail" type="text" placeholder="UpdatedEmail" value='<%=email %>' required></input><br>
		<input name="age" id="age" type="text" placeholder="age" value='<%=age %>' required></input><br>
		<select id="class" name="class" type="text" value='<%=class1 %>' placeholder="class" >
         <option value=0> select class</option>
         <option value=1> 1</option>
         <option value=2> 2</option>
         <option value=3> 3</option>
         <option value=4> 4</option>
         <option value=5> 5</option>
         <option value=6> 6</option>
         <option value=7> 7</option>
         <option value=8> 8</option>
         <option value=9> 9</option>
         <option value=10> 10</option>
         <option value=11> 11</option>
         <option value=12> 12</option>
         </select><br>
		<input type="submit" value="Update" onclick="valid();"></input><br>
	</form>
	</div>
</body>
</html>