<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		  
    		<script>
			function validateForm() {
			  var x = document.forms["myForm"]["emp_name"].value;
			  if (x == "") {
			    alert("Name must be filled out");
			    return false;
			  }
			  var y = document.forms["myForm"]["emp_id"].value;
			  if (y == "") {
			    alert("emp id must be filled out");
			    return false;
			  }
			  var z = document.forms["myForm"]["phone_no"].value;
			  if (z == "") {
			    alert("Phone must be filled out");
			    return false;
			  }
			  var a = document.forms["myForm"]["email_id"].value;
			  if (a == "") {
			    alert("Email must be filled out");
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
	
		<form:form action="updateEmployeeDetails" modelAttribute="employees" name="myForm" onsubmit="return validateForm()" method="POST">					
			<table>
				<tbody>					
				    <tr>
						<td><label>Employee name:</label></td>
						<td><form:input path="employee.emp_name" id="emp_name"  /></td>
					</tr>
					<tr>
						<td><label>Employee Id:</label></td>
						<td><form:input path="emp_id" id="emp_id" disabled="true"/></td>
					</tr>
					
					<tr>
						<td><label>Phone No:</label></td>
						<td><form:input path="phone_no" id="phone_no" autocomplete="off" /></td>
					</tr>
					
					<tr>
						<td><label>Email Id:</label></td>
						<td><form:input path="email_id" id="email_id"  autocomplete="off" /></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit"   value="Save" class="save" /></td>
					</tr>
				</tbody>
			</table>
		</form:form>	
	</div>

</body>

</html>










