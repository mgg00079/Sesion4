<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Página Principal</title>
</head>
<body>
	<h1>
		Inicio de sesión 
	</h1>
	<form action="/Login" method="post">
		Usuario:<br />
		<input type="text" name="user" size="5" required><br />
		Contraseña:<br />
		<input type="password" name="pass" size="5" required><br />
		<input type="submit" value="Enviar">
	</form>
</body>
</html>
