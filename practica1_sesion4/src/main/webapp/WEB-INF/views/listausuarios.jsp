<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<style>
	table th, td{
		text-align: center;
	}
	</style>
	<title>Lista de usuarios:</title>
</head>
<body>
	<h1>Usuarios registrados</h1>
	<table border="1">
		<tr>
			<th>Apellidos</th>
		
			<th>Nombre</th>
		
			<th>email</th>
		
			<th>Telefono</th>
			
			<th>Codigo Postal</th>
		</tr>
		<c:forEach items="${usuarios}" var="user" varStatus="estado">
			<tr>
				<td><c:out value="${user.apellidos}"/></td>
	
				<td><c:out value="${user.nombre}"/></td>
	
				<td><c:out value="${user.email}"/></td>
	
				<td><c:out value="${user.telefono}"/></td>
	
				<td><c:out value="${user.cp}"/></td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	<a href="home.jsp">Desconectar</a>
</body>
</html>

