<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Shipping Company</title>
</head>
<body>
<!-- This is where the model-attribute is used from the controller -->
	<form:form modelAttribute="shipC">
		<h1>Add Ship</h1>
		<table>
			<tr>
				<td>Company Name:</td>
				<!-- the path has to be the same name as in the model -->
				<td><form:input path="name"></form:input></td>

			</tr>
			<tr>
				<td>Home Port:</td>
				<td><form:input path="homePort"></form:input></td>
			</tr>
			<tr>
				<td>Balance:</td>
				<td><form:input path="balance"></form:input></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Add" /></td>
			</tr>
		</table>
	</form:form>
	<br>
	<a href="/index.html">Home</a>
</body>
</html>