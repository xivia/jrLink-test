<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h2>User Formular JHE</h2>

	<form name="inpForm" method="post" action="manage?action=${nextAction}"
		accept-charset="UTF-8" onsubmit="return validate();">

		<table>
			<tr>
				<td colspan="3"><a href="manage">back</a> to list</td>
			</tr>
			<tr>
				<td colspan="3">&nbsp;</td>
			</tr>
			<tr>
				<td>key</td>
				<td>&nbsp;</td>
				<td><input type="text" name="inpKeyD" value="${entryKey}" disabled /></td>
				<td><input type="hidden" name="inpKey" value="${entryKey}" /></td>
			</tr>
			<tr>
				<td>name</td>
				<td>&nbsp;</td>
				<td><input type="text" name="inpName" value="${entryName}" /></td>
			</tr>
			<tr>
				<td>nick</td>
				<td>&nbsp;</td>
				<td><input type="text" name="inpNick" value="${entryNick}" /></td>
			</tr>
			<tr>
				<td>e-mail</td>
				<td>&nbsp;</td>
				<td><input type="text" name="inpMail" value="${entryMail}" /></td>
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