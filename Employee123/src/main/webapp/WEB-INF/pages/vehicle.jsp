<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@include file="../includes/header3.jsp"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url value="/vehicle" var="userActionUrl" />


<form:form modelAttribute="vehicleData" action="${userActionUrl}">

	<div class="form-group">
		<form:label path="vehicleName">Name</form:label>
		<form:input path="vehicleName" type="text" class="form-control"
			id="exampleInputvehicleName1" placeholder="Name" />
		<form:errors path="vehicleName" cssClass="text-danger" />
	</div>
	<div class="form-group">
		<form:label path="type">Vehicle Type</form:label>
		<form:select path="type" class="form-control" id="exampleInputOrg1">
			<form:option value="">Select</form:option>
			<form:option value="Cycle">Cycle</form:option>
			<form:option value="Bike">Bike</form:option>
			<form:option value="Car">Car</form:option>
		</form:select>
		<form:errors path="type" cssClass="text-danger" />
	</div>
	<div class="form-group">
		<form:label path="Eid">Employee id</form:label>
		<form:input path="Eid" type="number" class="form-control"
			id="exampleInputId1" placeholder="Employee Id" value='${Eid}'
			readonly="true" />
		<form:errors path="Eid" cssClass="text-danger" />
	</div>
	<div class="form-group">
		<form:label path="vehicleNumber">Vehicle Number</form:label>
		<form:input path="vehicleNumber" type="text" class="form-control"
			id="exampleInputVehicleNumber1" placeholder="Vehicle Number" />
		<form:errors path="vehicleNumber" cssClass="text-danger" />
	</div>
	<div class="form-group">
		<form:label path="identification">Vehicle Identity</form:label>
		<form:textarea path="identification" class="form-control"
			id="exampleInputIdentity1" placeholder="Identification" />
		<form:errors path="identification" cssClass="text-danger" />
	</div>
	<button type="submit" class="btn btn-primary">Register</button>

</form:form>
<%@include file="../includes/footer.jsp"%>