<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login jrLink_JHE</title>
</head>
<body>
	<h2>Login jrLink_JHE</h2>
	<form name="inpLoginForm" method="post"
		action="manageLogin?action=${nextAction}" id="userform"
		accept-charset="UTF-8" onsubmit="return validate();">

		<table>
			<tr>
				<td colspan="3"><a href="/jrLink_JHE_WEB">back</a> to list</td>
			</tr>
			<tr>
				<td colspan="3">&nbsp;</td>
			</tr>
			<tr>
				<td>nick</td>
				<td>&nbsp;</td>
				<td><input type="text" name="inpNick" /></td>
			</tr>
			<tr>
				<td>passwort</td>
				<td>&nbsp;</td>
				<td><input type="password" name="inpPasswort" /></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td><input type="submit" name="inpSubmitButton" value="save" /></td>
			</tr>
		</table>
	</form>

</body>
</html>