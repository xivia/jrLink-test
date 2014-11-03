<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>JEE - JrList_JHE</h2>	
	<br />

	<table>
		<tr>
			<td colspan="7"><a href="manage">refresh</a> list &nbsp;|&nbsp;
				<a href="manage?action=new">new</a> record</td>
		</tr>
		<tr>
			<td colspan="7">&nbsp;</td>
		</tr>
		<tr>
			<td>key</td>
			<td>&nbsp;</td>
			<td>value</td>
			<td>&nbsp;</td>
			<td colspan="3">action</td>
		</tr>
		<c:forEach var="item" items="${resultList}">
			<tr>
				<td>${item.key}</td>
				<td>&nbsp;</td>
				<td>${item.name}</td>
				<td>&nbsp;</td>
				<td><a href="manage?action=edit&key=${item.key}">edit</a></td>
				<td>&nbsp;</td>
				<td><a href="manage?action=delete&key=${item.key}">delete</a></td>
			</tr>
		</c:forEach>
	</table>

	<br />

</body>
</html>