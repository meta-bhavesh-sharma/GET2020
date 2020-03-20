<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@include file="../includes/header3.jsp"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page import="java.io.File"%>
<%@page import="java.io.IOException"%>
<%@page import="java.awt.image.BufferedImage"%>
<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.io.ByteArrayOutputStream"%>

<%@page import="java.math.BigInteger"%>
<%@page import="javax.xml.bind.DatatypeConverter"%>
<%@page import="java.awt.image.BufferedImage"%>

<style>
#exampleInputGender2, #exampleInputGender1 {
	width: 1cm;
	hight: 1cm;
	height: 30px;
}
</style>
<div style="color: GREEN;">${MESSAGE}</div>
<%
	String path = (String) request.getAttribute("IMAGE");
	//write image
	try {
		String imgName = "C:\\" + path;
		BufferedImage bImage = ImageIO.read(new File(imgName));//give the path of an image
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(bImage, "jpg", baos);
		baos.flush();
		byte[] imageInByteArray = baos.toByteArray();
		baos.close();
		String b64 = DatatypeConverter.printBase64Binary(imageInByteArray);
%>
<img class="img-responsive" src="data:image/jpg;base64, <%=b64%>"
	height="150px" width="150px" />
<%
	} catch (IOException e) {
		System.out.println("Error: " + e);
	}
%>
<form method="post" action="/setimage" enctype="multipart/form-data">

	<input type="file" name="imageFile" accept="image/jpeg, image/png" />
	<input type="submit" value="upload" />

</form>
<spring:url value="/userhome" var="userActionUrl" />


<form:form modelAttribute="userData" action="${userActionUrl}">

	<form:hidden path="id" />
	<div class="form-group">
		<form:label path="email">Email address</form:label>
		<form:input path="email" type="text" class="form-control"
			id="exampleInputEmail1" placeholder="Email" value="${Data.email}"
			readonly="true" />
		<form:errors path="email" cssClass="text-danger" />
	</div>
	<div class="form-group">
		<form:label path="name">Name</form:label>
		<form:input path="name" type="text" class="form-control"
			id="exampleInputName1" placeholder="Name" value="${Data.name}"
			readonly="true" />
		<form:errors path="name" cssClass="text-danger" />
	</div>
	<div class="form-group">
		<form:label path="gender" value="${Data.gender}">Gender</form:label>
		<form:radiobutton path="gender" class="form-control" name="Male"
			value="Male" id="exampleInputGender1" />
		Male
		<form:radiobutton path="gender" class="form-control" name="Female"
			value="Female" id="exampleInputGender1" />
		Female
		<form:errors path="name" cssClass="text-danger" />
	</div>
	<div class="form-group">
		<form:label path="contact">Contact Number</form:label>
		<form:input path="contact" type="text" class="form-control"
			id="exampleInputContact1" placeholder="Contact Number"
			value="${Data.contact}" readonly="true" />
		<form:errors path="contact" cssClass="text-danger" />
	</div>
	<div class="form-group">
		<form:label path="org">Organization</form:label>
		<form:input type="text" path="org" class="form-control"
			id="exampleInputOrg1" value="${Data.org}" readonly="true" />
		<form:errors path="org" cssClass="text-danger" />
	</div>
	<input type="Button" value="Edit Details" class="btn btn-primary"
		onclick="edit()"></input>
	<br>
	<br>
	<input id="submit" type="submit" class="btn btn-primary"
		value="Submit Details" hidden="false"></input>
	<br>

</form:form>
<%@include file="../includes/footer.jsp"%>


<script>
	function edit() {
		document.getElementById("exampleInputName1").readOnly = false;
		document.getElementById("exampleInputEmail1").readOnly = false;
		document.getElementById("exampleInputContact1").readOnly = false;
		document.getElementById("submit").hidden = "";

	}
</script>