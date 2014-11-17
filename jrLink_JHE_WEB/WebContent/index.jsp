<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>jrLink_JHE</title>
</head>
<body>
	<h2>jrLink_JHE</h2>

	<br>
	Click <a href="manageLogin">here</a> login
	<br> 
	Click <a href="manageLink">here</a> Link verwalten
	<br>
	Click <a href="http://localhost:8080/jrLink_JHE_WEB/rest/service/link">here</a> Webservice Aufrufen
	<br>
	<br>
	<br>
	<c:if test="${LoginBean.login}">
		<br>
		Click <a href="manage">here</a> Benutzer bearbeiten<br />
		<br>
		<br />
		Click <a href="manageRole">here</a> Rolen bearbeiten.<br />
		<br>
		Click <a href="manageLogin?action=logout&key=${LoginBean.user.key}">here</a> logout<br />
	</c:if>
	<br>
	<br>
	<br />
	<h3>Eingelogt: ${LoginBean.login}</h3>
	<h3>Login Name: ${LoginBean.user.name}</h3>



</body>
</html>
