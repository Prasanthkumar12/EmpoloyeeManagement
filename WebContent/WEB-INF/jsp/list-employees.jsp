<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>List Employees</title>
	
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
			<!-- put new button: Add Customer -->
			<input type="button" value="Create Employee"
				   onclick="window.location.href='showFormForAdd'; return false;"
				   class="add-button"
			/>
			<input type="button" value="view Customer"
				   onclick="window.location.href='showFormForView'; return false;"
				   class="add-button"
			/>                  
			<input type="button" value="update Customer"
				   onclick="window.location.href='showFormForUpdate'; return false;"
				   class="add-button"
			/>
			<input type="button" value="inactive Customer"
				   onclick="window.location.href='showFormForInActive'; return false;"
				   class="add-button"
			/>
			</br>
			</br>
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
				</tr>
				<!-- loop over and print our customers -->
				<c:forEach var="tempEmployee" items="${employees}">
					<tr>
						<td> ${tempEmployee.address.emp_id} </td>
						<td> ${tempEmployee.emp_name} </td>
						<td> ${tempEmployee.date_of_joining} </td>
						<td> ${tempEmployee.employee_status} </td>
						<td> ${tempEmployee.time_stamp} </td>
						<td> ${tempEmployee.address.phone_no} </td>						
						<td> ${tempEmployee.address.email_id} </td>						
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>

</html>
