<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="style.css" rel="stylesheet" type="text/css">
    <title>Epmloyee
    </title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
    <form id="empregester" method="POST" action="login">
        <h1>Login Here</h1>
        <input name="email" type="text" placeholder="Email" required></input><br>
        <input name="password" type="password" placeholder="Password" required></input><br>
        <input type="submit" value="Login" onclick="valid();"></input><br>
        <a href="http://localhost:8080/MetaServer/register.jsp">new user click here</a>
    </form>
</body>
</html>