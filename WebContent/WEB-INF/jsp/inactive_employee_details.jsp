<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>List Employee</title>
			<link type="text/css"
		  rel="stylesheet"
		  href="<c:url value="/resources/css/style.css"/>">

	<link type="text/css"
		  rel="stylesheet"
		  href="<c:url value="/resources/css/add-customer-style.css"/>">
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Employee Management</h2>
		</div>
	</div>
	<div id="container">	
		<div id="content">
			<!--  add our html table here -->		
			<table>
				<tr>
					<th>Employee Id</th>
					<th>Employee Name</th>
					<th>Date Of Joining</th>
					<th>Employee Status</th>
					<th>Time Stamp</th>
					<th>Phone No</th>
					<th>Email id</th>
					<th>Action</th>
				</tr>
				<!-- loop over and print our customers -->
				<c:forEach var="tempEmployee" items="${employees}">
					<!-- construct an "delete" link with customer id -->
					<c:url var="deleteLink" value="/inactive">
						<c:param name="address.emp_id" value="${tempEmployee.address.emp_id}" />
					</c:url>										
					<tr>
						<td> ${tempEmployee.address.emp_id} </td>
						<td> ${tempEmployee.emp_name} </td>
						<td> ${tempEmployee.date_of_joining} </td>
						<td> ${tempEmployee.employee_status} </td>
						<td> ${tempEmployee.time_stamp} </td>
						<td> ${tempEmployee.address.phone_no} </td>						
						<td> ${tempEmployee.address.email_id} </td>						
						<td>
							<a href="${deleteLink}"
							   onclick="if (!(confirm('Are you sure you want to inactive this employee?'))) return false">Inactive</a>
						</td>
					</tr>				
				</c:forEach>				
			</table>
		</div>
				<p>
			<a href="list">Back to List</a>
		</p>
	</div>
</body>
</html>