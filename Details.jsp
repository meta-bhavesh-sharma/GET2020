<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="style.css" rel="stylesheet" type="text/css">
    <title>Student
    </title>
    <script src="register.js"> </script>

</head>
<body>
<h1>Student Registration</h1>
    <form id="details" method="POST" action="StudentRegister">
        <h2>Fill Student Details here</h2>
        <br><input id="fstname" name="fstname" type="text" placeholder="First Name" ></input><br>
        <br><input id="lstname" name="lstname" type="text" placeholder="Last Name" ></input><br>
        <br><input id="fname" name="fname" type="text" placeholder="Father Name" ></input><br>
        <input id="email" name="email" type="text" placeholder="Email" ></input><br>
         <input id="age" name="age" type="text" placeholder="Age" ></input><br>
         <select id="class" name="class" type="text" placeholder="class" >
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
        <input type="submit" value="Register" onclick="valid();"></input><br>
        <a  href="login.html" >
        </form>
</body>
</html>