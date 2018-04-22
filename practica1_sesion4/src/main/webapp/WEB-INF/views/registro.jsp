<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Info registro</title>
	<style>
	table th, td{
		text-align: center;
	}
	</style>
</head>
<body>
	<h1>Datos de usuario</h1>
	<table>
		<tr>
			<th>Nombre</th>
			<th>Apellidos</th>
			<th>Email</th>
			<th>Telefono</th>
			<th>Codigo Postal</th>
		</tr>
		
		<tr>
			<td><c:out value="${usuario.nombre}"/></td>
			<td><c:out value="${usuario.apellidos}"/></td>
			<td><c:out value="${usuario.email}"/></td>
			<td><c:out value="${usuario.telefono}"/></td>
			<td><c:out value="${usuario.cp}"/></td>
		</tr>
		
	</table>
	<a href="home.jsp">Desconectar</a>
</body>
</html>