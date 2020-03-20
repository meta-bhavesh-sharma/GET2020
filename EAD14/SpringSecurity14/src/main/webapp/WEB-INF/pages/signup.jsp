<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@include file="../includes/Header1.jsp"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<h1>Employee Registration</h1>
<style>
#exampleInputGender2, #exampleInputGender1 {
	width: 1cm;
	hight: 1cm;
	height: 30px;
}
</style>
<spring:url value="/signup" var="userActionUrl" />


<form:form modelAttribute="employee" action="${userActionUrl}">
	<form:errors />
	<form:hidden path="path" value="download.jpg" />
	<div class="form-group">
		<form:label path="email">Email address</form:label>
		<form:input path="email" type="text" class="form-control"
			id="exampleInputEmail1" placeholder="Email" />
		<form:errors path="email" cssClass="text-danger" />
	</div>
	<div class="form-group">
		<form:label path="name">Name</form:label>
		<form:input path="name" type="text" class="form-control"
			id="exampleInputName1" placeholder="Name" />
		<form:errors path="name" cssClass="text-danger" />
	</div>
	<div class="form-group">
		<form:label path="gender">Gender</form:label>
		<br> Male
		<form:radiobutton path="gender" class="form-control" name="Male"
			value="Male" id="exampleInputGender1" />
		Female
		<form:radiobutton path="gender" class="form-control" name="Female"
			value="Female" id="exampleInputGender2" />
		<form:errors path="gender" cssClass="text-danger" />
	</div>
	<div style="color: red;">${MATCHPASS}</div>
	<div class="form-group">
		<form:label path="password">Password</form:label>
		<form:input path="password" type="password" class="form-control"
			id="exampleInputPassword1" placeholder="Password" />
		<form:errors path="password" cssClass="text-danger" />
	</div>
	<div class="form-group">
		<form:label path="confirmPassword">Confirm Password</form:label>
		<form:input path="confirmPassword" type="password"
			class="form-control" id="exampleInputConfirmPassword1"
			placeholder="Confirm Password" />
		<form:errors path="confirmPassword" cssClass="text-danger" />
	</div>
	<div class="form-group">
		<form:label path="contact">Contact Number</form:label>
		<form:input path="contact" type="text" class="form-control"
			id="exampleInputContact1" placeholder="Contact Number" />
		<form:errors path="contact" cssClass="text-danger" />
	</div>
	<div class="form-group">
		<form:label path="org">Organization</form:label>
		<form:select path="org" class="form-control" id="exampleInputOrg1">
			<form:option value="--Select--" />
			<form:option value="Metacube" />
			<form:option value="Google" />
			<form:option value="Apple" />
			<form:option value="Microsoft" />
		</form:select>
		<form:errors path="org" cssClass="text-danger" />
	</div>
	<button type="submit" class="btn btn-primary">Submit</button>

</form:form>
<%@include file="../includes/footer.jsp"%>