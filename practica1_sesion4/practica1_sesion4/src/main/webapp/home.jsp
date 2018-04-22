<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<html>
<head>

	<title>Pagina principal</title>

</head>
<body>
<%--Esto es index.html--%>
	
	<h2>Login de usuario</h2>
	<form action="Login" method="post">
		Nombre de usuario: <br /><input type="text" name="name" size="20" required><br />
		Contraseña: <br /><input type="password" name="pass" size="10" required><br />
		<input type="submit" value="Enviar">
	</form>

</body>
</html>