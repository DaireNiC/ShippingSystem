<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Order</title>
</head>
<body>
	<form:form modelAttribute="order">
		<table>
			<tr>
				<td>Shipping Name:</td>
				<td><form:select path="ship">
					<c:forEach items="${countryList}" var="line">
						<option><c:out value="${line}" /></option>
					</c:forEach>
				</form:select></td>
			</tr>
			<tr>
				<td>Shipping Company:</td>
				<td><form:select path="ship">
						<form:options items="${countryList}" />
					</form:select></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Order Ship" /></td>
			</tr>
		</table>
	</form:form>
	<br>
	<a href="/index.html">Home</a>
</body>
</html>