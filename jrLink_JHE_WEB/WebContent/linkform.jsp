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
	<a href="index.jsp">home</a>
	<h2>Link Formular JHE</h2>

	<form name="inpForm" method="post"
		action="manageLink?action=${nextAction}" accept-charset="UTF-8"
		onsubmit="return validate();">

		<table>
			<tr>
				<td colspan="3"><a href="manageLink">back</a> to list</td>
			</tr>
			<tr>
				<td colspan="3">&nbsp;</td>
			</tr>
			<tr>
				<td>key</td>
				<td>&nbsp;</td>
				<td><input type="text" name="inpKeyD" value="${link.key}"
					disabled /></td>
				<td><input type="hidden" name="inpKey" value="${link.key}" /></td>
			</tr>
			<tr>
				<td>name</td>
				<td>&nbsp;</td>
				<td><input type="text" name="inpName" value="${link.name}" /></td>
			</tr>
			<tr>
				<td>value</td>
				<td>&nbsp;</td>
				<td><input type="text" name="inpValue" value="${link.value}" /></td>
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