<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.management.customer.entity.Customer"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CRM</title>
<style type="text/css">
input[type=text] {
	width: 50%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type=submit] {
	width: 150px;
	background-color: #58adbe;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

.labels {
	width: 100px;
	display: inline-block
}

.submit {
	margin-left: 104px!important;
}

.form {
	width: 50%;
	margin-left: 200px;
}

.backToList {
	margin-top: 40px;
	display: block;
}

.h3 {
	padding: 0;
	margin: 0;
}
</style>
</head>
<body>
	<div>
		<h1
			style="width: 100%; background: #58adbe; padding: 30px; text-align: center">Customer
			Relationship Management</h1>
		<form class="form" action="/customer-details/Customer/update-customer"
			method="post">
			<h3 class="h3">Save Customer</h3>
			<%
			Customer cust = (Customer) request.getAttribute("customerInfo");
			
			out.println("<input type='hidden' name='id' value="+cust.getId()+
					" placeholder='CustomerId' /> <br><br> <label class='labels'>First Name: </label> <input type='text' value='"+cust.getFirstName()+
					"' name='firstName' placeholder='First Name' /><br> <label class='labels'>Last Name: </label> <input type='text' value='"+cust.getLastName()+ 
					"' name='lastName' placeholder='Last Name' /><br><label class='labels'>Email: </label> <input type='text' value='"+cust.getEmail()+ 
					"' name='email' placeholder='Email' /><br><input class='submit' type='submit' name='s' value='Save' />");
			%>
			<a class="backToList"
				href="/customer-details/Customer/show-customers">Back To List</a>

		</form>
	</div>
</body>
</html>