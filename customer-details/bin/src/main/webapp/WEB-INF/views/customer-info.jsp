<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.util.List,com.management.customer.entity.Customer"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CRM</title>
<style>
a:hover#addLink, a:active#addLink {
	background-color: #D3D3D3;
}

a:link#addLink {
	background-color: #c1c1c1;
	border-radius: 10px;
	color: black;
	padding: 14px 25px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	margin-bottom: 15px
}

a:visited#addLink {
	color: black;
}

#customers {
	border-collapse: collapse;
	width: 100%;
}

#customers td, #customers th {
	border: 1px solid #ddd;
	padding: 8px;
}

#customers tr:nth-child(even) {
	background-color: #f2f2f2;
}

#customers tr:hover {
	background-color: #ddd;
}

#customers th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	background-color: #58adbe;
	color: white;
}

button {
	background: none !important;
	border: none;
	padding: 0 !important;
	color: #069;
	text-decoration: underline;
	cursor: pointer;
	font-size: 15px;
}
</style>
</head>
<body>
	<script type="text/javascript">
		function myFunction(id) {
			if (confirm("Are you sure you want to delete?")) {
				window.location.href = '/customer-details/Customer/delete-customer?id='
						+ id
			}
		}
	</script>
	<div>
		<h1
			style="width: 100%; background: #58adbe; padding: 30px; text-align: center">Customer
			Relationship Management</h1>

		<a id="addLink" href="/customer-details/Customer/show-form">Add
			More Customers</a>
		<div>
			<%
			List<Customer> customers = (List<Customer>) request.getAttribute("customerInfo");
			out.println("<table id='customers'><tr><th>First Name</th><th>Last Name</th><th>Email</th><th>Action</th></tr>");
			for (Customer cust : customers) {
				int id = cust.getId();
				out.println("<tr><td>" + cust.getFirstName() + "</td><td>" + cust.getLastName() + "</td><td>" + cust.getEmail()
				+ "</td><td><button id='deleteUser' onclick='myFunction(\"" + id
				+ "\")'>Delete</button> | <a style='color:#069!important; font-size: 15px!important; font-family: system-ui;' href='/customer-details/Customer/open-update-form?id="
				+ cust.getId() + "'>Update</a></td></tr>");
			}

			out.println("</table>");
			%>
		</div>
	</div>
</body>
</html>