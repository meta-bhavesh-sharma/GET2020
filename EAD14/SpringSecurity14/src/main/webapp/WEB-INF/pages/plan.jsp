<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@include file="../includes/header3.jsp"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<h1>Plan Purchase</h1>
<spring:url value="/plan" var="userActionUrl" />


<form:form modelAttribute="planData" action="${userActionUrl}">
	<div style="color: red;">${ERROR}</div>
	<form:hidden path="rid" value='${Rid}' />
	<div class="form-group">
		<form:label path="period">Subscription</form:label>
		<form:select path="period" class="form-control"
			id="exampleInputPeriod1" onchange="setPrice()">
			<form:option value="--Select--" />
			<form:option value='Daily' />
			<form:option value='Monthly' />
			<form:option value='Yearly' />
		</form:select>
		<form:errors path="period" cssClass="text-danger" />
	</div>
	<div class="form-group">
		<form:hidden path="price" class="form-control" id="exampleInputPrice1"
			readonly="true" />
	</div>
	<div class="form-group">
		<form:label path="currency">Currency</form:label>
		<form:select path="currency" class="form-control"
			id="exampleInputCurrency" onchange="setCurrency()">
			<form:option value="--Select--" />
			<form:option value="INR" />
			<form:option value="YEN" />
			<form:option value="USD" />
			<form:errors path="currency" cssClass="text-danger" />
		</form:select>
	</div>
	<div class="form-group">
		<form:label path="rate">Price</form:label>
		<form:input type="text" path="rate" class="form-control"
			id="exampleInputRate1" readonly="true" />
		<form:errors path="rate" cssClass="text-danger" />
	</div>
	<button type="submit" class="btn btn-primary">Submit</button>

</form:form>
<form id="supliment">
	<input type="hidden" id="dailyrate" value='${daily}'> <input
		type="hidden" id="monthlyrate" value='${monthly}'> <input
		type="hidden" id="yearlyrate" value='${yearly}'>
</form>
<%@include file="../includes/footer.jsp"%>

<script>
function setPrice()
{
	if(document.getElementById("exampleInputPeriod1").value=="Daily")
		{
		document.getElementById("exampleInputPrice1").value=document.getElementById("dailyrate").value;
		document.getElementById("exampleInputRate1").value=document.getElementById("dailyrate").value;
		}
	if(document.getElementById("exampleInputPeriod1").value=="Monthly")
		{
			document.getElementById("exampleInputPrice1").value=document.getElementById("monthlyrate").value;
			document.getElementById("exampleInputRate1").value=document.getElementById("monthlyrate").value;
		}
	if(document.getElementById("exampleInputPeriod1").value=="Yearly")
	{
		document.getElementById("exampleInputPrice1").value=document.getElementById("yearlyrate").value;
		document.getElementById("exampleInputRate1").value=document.getElementById("yearlyrate").value;
	}
}
function setCurrency()
{
	var rate=document.getElementById("exampleInputPrice1").value;
	if(document.getElementById("exampleInputCurrency").value=="USD")
	{
		document.getElementById("exampleInputRate1").value=(rate*0.07).toFixed(2);
	}
if(document.getElementById("exampleInputCurrency").value=="YEN")
	{
		document.getElementById("exampleInputRate1").value=(rate*1.53).toFixed(2);
	}
if(document.getElementById("exampleInputCurrency").value=="INR")
{
	document.getElementById("exampleInputRate1").value=rate;
}
	}
</script>