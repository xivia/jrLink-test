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
	<h2>User Formular JHE</h2>

	<form name="inpForm" method="post" action="manage?action=${nextAction}"
		id="userform" accept-charset="UTF-8" onsubmit="return validate();">

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
				<td><input type="text" name="inpKeyD" value="${user.key}"
					disabled /></td>
				<td><input type="hidden" name="inpKey" value="${user.key}" /></td>
			</tr>
			<tr>
				<td>name</td>
				<td>&nbsp;</td>
				<td><input type="text" name="inpName" value="${user.name}" /></td>
			</tr>
			<tr>
				<td>vorname</td>
				<td>&nbsp;</td>
				<td><input type="text" name="inpVorName"
					value="${user.vorname}" /></td>
			</tr>
			<tr>
				<td>nick</td>
				<td>&nbsp;</td>
				<td><input type="text" name="inpNick" value="${user.nick}" /></td>
			</tr>
			<tr>
				<td>e-mail</td>
				<td>&nbsp;</td>
				<td><input type="text" name="inpMail" value="${user.mail}" /></td>
			</tr>
			<tr>
				<td>passwort</td>
				<td>&nbsp;</td>
				<td><input type="password" name="inpPasswort"
					value="${user.passwort}" /></td>
			</tr>
			<tr>
				<td>role</td>
				<td>&nbsp;</td>
				<td><select name="inprole">
						<c:forEach var="item" items="${listrole}">
							<c:choose>
								<c:when test="${item.key == user.role.key}">
									<option selected value="${item.key}">${item.name}</option>
								</c:when>
								<c:otherwise>
									<option value="${item.key}">${item.name}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>erstellt am</td>
				<td>&nbsp;</td>
				<td><input type="text" name="inpcrdt" value="${user.crdt}"
					disabled /></td>
			</tr>
			<tr>
				<td>geändert</td>
				<td>&nbsp;</td>
				<td><input type="text" name="inpchdt" value="${user.chdt}"
					disabled /></td>
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