<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administrador</title>
</head>
<body>
	<h1>Lista de usuarios registrados</h1>
		<table border="1">
			<tr>
				<th>Usuario</th>
				<th>Contraseña</th>
				<th>Nombre</th>
				<th>Apellidos</th>
				<th>Email</th>
				<th>Teléfono</th>
				<th>Código Postal</th>
			</tr>
			<c:forEach items="${lista}" var="user" varStatus="estado">
				<tr>
					<td><c:out value="${user.usuario}"/></td>
					<td><c:out value="${user.contraseña}"/></td>
					<td><c:out value="${user.nombre}"/></td>
					<td><c:out value="${user.apellidos}"/></td>
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