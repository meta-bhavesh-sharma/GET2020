<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="style.css" rel="stylesheet" type="text/css">
    <title>Epmloyee
    </title>
    <script src="register.js"> </script>
    <style> select {
	margin: 10px;
	padding: 7px;
	text-align: center;
	font-size: 20px;
	height: 1.5cm;
	width: 6cm;
	background-color: initial;
}</style>

</head>
<body>
<h1>Metacube Employee Registration</h1>
    <form id="empregister" method="POST" action="register">
        <h2>Employee Registration form</h2>
        <br><input id="empname" name="empname" type="text" placeholder="Full Name" ></input><br>
        <div style="font-size:20px;color: darkseagreen;">Gender
            <label><input id="gender" type="radio" name="gender" value="Male"></input>Male</label>
            <label><input id="gender" type="radio" name="gender" value="Female"></input>Female</label><br>
        </div>
        <input id="email" name="email" type="text" placeholder="Email" ></input><br>
        <input id="password" name="password" type="password" placeholder="Password" ></input><br>
        <input id="cpassword" name="cpassword" type="password" placeholder="Confirm Password" ></input><br>
        <input id="contact" name="contact" type="text" placeholder="Contact Number" ></input><br>
        <select id="org" name="org">
        <option>Select Organisation</option>
        <option>Metacube</option>
        <option>Google</option>
        <option>Microsoft</option>
        <option>Apple</option>
        </select><br>
        <input type="submit" value="Register" onclick="valid();"></input><br>
        <a  href="login.jsp" > Alredy Registered Cilck Here</a>
        </form>
</body>
</html>