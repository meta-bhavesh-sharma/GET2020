<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css" type="text/css">
    <script src="script.js"></script>
</head>
<body>
<% String email=(String)session.getAttribute("Id");
    if(email.length()==0)
    {
    	response.sendRedirect("register.jsp");
    }
    %>
<h1>Metacube Employee Details</h1>
    <form id="empregister" method="post" action="update">
        <br><input id="empname" name="empname" type="text" placeholder="Full Name" value="${namef}" readonly></input><br>
        <div style="font-size:20px;color: darkseagreen;">Gender
            <label><input id="gender" type="radio" name="gender" value="Male"></input>Male</label>
            <label><input id="gender" type="radio" name="gender" value="Female"></input>Female</label><br>
        </div>
        <input id="email" name="email" type="text" placeholder="Email" value="${emailf}" readonly></input><br>
        <input id="password" name="password" type="password" placeholder="Password" value="${passwordf}" readonly></input><br>
        <input id="cpassword" name="cpassword" type="password" placeholder="Confirm Password" value="${passwordf}" readonly ></input><br>
        <input id="contact" name="contact" type="text" placeholder="Contact Number" value="${contactf}" readonly></input><br>
        <a href="http://localhost:8080/MetaServer/list.jsp">  Back  </a><br><a href="http://localhost:8080/MetaServer/home.jsp">  Home  </a><br>
        
        </form>
</body>
</html>