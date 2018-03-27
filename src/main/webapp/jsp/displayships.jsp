<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<style>
table {
	border-bottom: 1px solid gray;
	font-family: Tahoma, Verdana, Segoe, sans-serif;
}

th {
	border-bottom: 1px solid gray;
	background: #0775d3;
	margin-bottom: 22px;
	padding: 10px;
	color: #FFFFFF;
	text-align: left;
}

td {
	border-top: 1px solid #FFFFFF;
	background: #D2DEEF;
	text-align: left;
}

tr {
	border-top: 1px solid #FFFFFF;
	background: none repeat scroll 0 0 #EAEFF7;
	text-align: left;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Ships</h1>
	<table>
		<tr>
			<th>Name</th>
			<th>Passengers</th>
			<th>Cost</th>
			<th>Length(Metres)</th>
			<th>Shipping Company</th>
		</tr>

		<c:forEach items="${ships}" var="ship">

			<tr>
				<td>${ship.name}</td>
				<td>${ship.passengers}</td>
				<td>${ship.cost}</td>
				<td>${ship.metres}</td>
				<td>${ship.shippingCompany.name}</td>
			</tr>

		</c:forEach>
	</table>

	<br>
	<a href="/index.html">Home</a>
</body>
</html>