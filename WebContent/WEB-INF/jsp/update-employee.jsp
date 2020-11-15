<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
	<title>Update Employee</title>

		<link type="text/css"
		  rel="stylesheet"
		  href="<c:url value="/resources/css/style.css"/>">

	<link type="text/css"
		  rel="stylesheet"
		  href="<c:url value="/resources/css/add-customer-style.css"/>">

	<style>
	.error
	   {
	     text-decoration:none;
	     font-size:18px;
	     line-height:10%;
	     padding-bottom:10px;
	     color:#FF0000;
	     font-weight:bold;
	   }
	</style>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
  		<script>
		function validateForm() {
		  var x = document.forms["myForm"]["address.emp_id"].value;
		  if (x == "") {
		    alert("emp id must be filled out");
		    return false;
		  }
		}
		</script>
</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2> Employee Management System</h2>
		</div>
	</div>

	<div id="container">
		<h3>Update Employee</h3>
	
		<form:form action="updateEmployee" name="myForm" onsubmit="return validateForm()" modelAttribute="employees" method="POST">
					
			<table>
				<tbody>
					<tr>
						<td><label>Employee Id:</label></td>
						<td><form:input path="address.emp_id"   autocomplete="off" /></td>
						<td><p class = "error">${error}</p></td>
						
					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>

				
				</tbody>
			</table>
		</form:form>
	</div>
</body>

</html>