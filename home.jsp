<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script>
function edit()
{
	document.getElementById("empname").readOnly=false;
	document.getElementById("email").readOnly=false;
	document.getElementById("contact").readOnly=false;
	document.getElementById("submit").hidden="";
	}
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>home</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
<% String email=(String)session.getAttribute("Id");
    if(email.length()==0)
    {
    	response.sendRedirect("register.jsp");
    }
    %>
<form method="post" action="Show">
<input type="hidden" name="org" value="${org}">
<input type="submit" value="Show Friends">
</form method="post" action="logout">
<form method="post" action="logout">
<input type="submit" value="Log Out">
</form>
<h1>Metacube Employee Details</h1>
    <form id="empregister" method="post" action="update">
        <br><input id="empname" name="empname" type="text" placeholder="Full Name" value="${name}" readonly></input><br>
        <div style="font-size:20px;color: darkseagreen;">Gender
            <label><input id="gender" type="radio" name="gender" value="Male"></input>Male</label>
            <label><input id="gender" type="radio" name="gender" value="Female"></input>Female</label><br>
        </div>
        <input id="email" name="email" type="text" placeholder="Email" value="${email}" readonly></input><br>
        <input id="password" name="password" type="password" placeholder="Password" value="${password}" readonly></input><br>
        <input id="cpassword" name="cpassword" type="password" placeholder="Confirm Password" value="${password}" readonly ></input><br>
        <input id="contact" name="contact" type="text" placeholder="Contact Number" value="${contact}" readonly></input><br>
        <input type="Button" value="Edit Details" onclick="edit()"></input><br>
        <input id="submit" type="submit" value="Submit Details" hidden="false"></input><br>
        <input name="rid" id="submit" type="hidden" value="${Rid}"></input><br>
        
        </form>
</body>
</html>