<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Order</title>
</head>
<body>
	<h1>Create Order</h1>
	
	<form:form modelAttribute="order">
 		<table>
   			<tr>
				<td>Ship:</td>
				<td><form:select path="ship.sid" items="${shipList}" /></td>
				<td><form:errors path="ship.sid" items="${shipList}" /></td>
			</tr>
			<tr>
				<td>Shipping Company:</td>
				<td><form:select path="shippingCompany.scid" items="${compList}" /></td>
				<td><form:errors path="shippingCompany.scid"></form:errors></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="Add"/>
				</td>
			</tr>
		</table> 
	</form:form>
    <a href="/">Home</a>
</body>
</html>