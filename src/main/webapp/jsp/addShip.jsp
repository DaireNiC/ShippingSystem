<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add A Ship</title>
</head>
<body>
	<!-- This is where the model-attribute is used from the controller -->
	<form:form modelAttribute="ship">
		<h1>Add Ship</h1>
		<table>
			<tr>
				<td>Ship Name:</td>
				<!-- the path has to be the same name as in the model -->
				<td><form:input path="name"></form:input></td>

			</tr>
			<tr>
				<td>Passengers:</td>
				<td><form:input path="passengers"></form:input></td>
			</tr>
			<tr>
				<td>Cost:</td>
				<td><form:input path="cost"></form:input></td>
			</tr>
			<tr>
				<td>Metres:</td>
				<td><form:input path="metres"></form:input></td>
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