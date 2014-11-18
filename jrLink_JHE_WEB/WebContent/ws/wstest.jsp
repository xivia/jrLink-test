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
		
	<form name="inpWsTestForm" method="post"
		action="manageWsTest?action=loudLink" id="wsTestForm"
		accept-charset="UTF-8" onsubmit="return validate();">

		<table>
			<tr>
				<td colspan="3"><a href="/jrLink_JHE_WEB">back</a> to list</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<c:if test="${loudLink}">
			<tr>
			    <td>Test loudLink</td>
			</tr>
			</c:if>
			<tr>
				<td colspan="3">&nbsp;</td>
			</tr>
			<tr>
				<td>ID</td>
				<td>&nbsp;</td>
				<td><input type="text" name="inpID" /></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td><input type="submit" name="inpSubmitButton" value="loud" /></td>
			</tr>
		</table>
	</form>
	
	
	Click <a href="http://localhost:8080/jrLink_JHE_WEB/rest/service/link">here</a> Einfache Liste der Links als WebServives

</body>
</html>