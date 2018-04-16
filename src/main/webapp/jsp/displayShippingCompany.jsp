<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link href="/css/style.css" rel="stylesheet" />

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shipping Company Page</title>
</head>
<body>
	<h1>Companies</h1>
	<table>
		<tr>
			<th>Name</th>
			<th>Home Port</th>
			<th>Balance</th>
			<th>ships</th>
		</tr>

		<c:forEach items="${shippingCompany}" var="shipC">

			<tr>
				<td>${shipC.name}</td>
				<td>${shipC.homePort}</td>
				<td>${shipC.balance}</td>

				<td>
					<c:forEach items="${shipC.ships}" var="comp">
						<li>${comp.name},${comp.metres}Mtrs,${comp.cost}</li>
					</c:forEach>
				</td>
			</tr>

		</c:forEach>
	</table>
	
	<br>
	<a href="/index.html">Home</a>
</body>
</html>