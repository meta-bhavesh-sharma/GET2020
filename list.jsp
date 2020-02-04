<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="java.util.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>
        home
    </title>
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
    <form id="friendsSelectForm" action="FriendData" method="post">
		<div><center>Select your friend by Email</center></div>>
    <select id="friendsList" name="friendsList"></select></br>
    <input type="submit"></form>
  <% ArrayList<String> listOfFriends=(ArrayList<String>)session.getAttribute("emaillist");%>

	<script>
	var NoOfFriends="<%= listOfFriends.size()%>";
	var friends="<%= listOfFriends %>";
	var friendArray=[];
	var friend="";
	for(var i=1;i<friends.length-1;i++)
	{
	if(friends[i]==",")
		{
		friendArray.push(friend);
		friend="";
		i++;
		}
	else
		{
			friend=friend+friends[i];
		}
	}
	friendArray.push(friend);
	for(var i=0;i<NoOfFriends;i++)
		{
		var option=document.createElement("option");
		option.value=friendArray[i];
		option.innerHTML=friendArray[i];
		document.getElementById("friendsList").appendChild(option);
		}
	</script>

</body>
</html> 