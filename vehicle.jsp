<!DOCTYPE html>
<html>

<head>
    <link href="style.css" rel="stylesheet" type="text/css">
    <title>Epmloyee
    </title>
    <script src="register.js"> </script>
    
   
</head>
<% String email=(String)session.getAttribute("Id");
    if(email.length()==0)
    {
    	response.sendRedirect("register.jsp");
    }
    %>
<body>
    <form id="vehicle" method="GET" action="plan" >
        <h2>Employee  vichle Registration form</h2>
        <input id="Rid" type="text" placeholder="Registration id" readonly></input><br>
        <br><input id="vname" type="text" placeholder="Veichle Name" required></input><br>
        <div style="font-size: 20px;color:darkseagreen">
            Type<label><input id="check1" type="checkbox"  name="Type"></input>Cycle</label>
            <label><input id="check2" type="checkbox"  name="Type"></input>Moter Bike</label>
            <label><input id="check3" type="checkbox"  name="Type"></input>Four Wheeler<br></label>
        </div>
        <input id="vnum" type="text" placeholder="vichle Number"></input><br>
        <textarea placeholder="Identifcation"></textarea><br>
		<input type="button" value="Go" onclick="purchase();">
    </form>

</body>

</html>