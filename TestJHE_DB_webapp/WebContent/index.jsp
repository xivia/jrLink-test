<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Titel von TestJHE-webapp</title>
</head>
<body>
	<h1>TestJHE-webapp von Jörg Herzig</h1>
	<a href="HalloServlet">Testseite EJB</a>

	<br>
	<form method="POST" action="TestDB">
		ID: <input type="text" name="getName" /> <input type="submit"
			value="getName" />
	</form>
	<br>
	<h3>Neuner DB Eintrag erstellen</h3>
	<form method="POST" action="TestDB">
		Name: <input type="text" name="setName" /> <input type="submit"
			value="setName" />
	</form>
	<br>
	<form method="POST" action="TestDB">
		<input type="submit" name="getAllName" value="getAllName" />
	</form>

</body>

</html>