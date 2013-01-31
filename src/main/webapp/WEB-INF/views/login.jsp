<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<style>
.errorblock {
	color: #ff0000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
</head>
<body onload="document.loginForm.j_username.focus();">
	<h1>Login</h1>
	<c:if test="${not empty error}">
		<div class="errorblock">
			Login attempt failed, try again.<br /> 
			<c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>
		</div>
	</c:if>
	<form name="loginForm" action="<c:url value="j_spring_security_check" />"
		method="POST">
		<table>
			<tr>
				<td>User:</td>
				<td><input type="text" name="j_username" value=""></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="j_password" /></td>
			</tr>
			<tr>
				<td colspan="2"><input name="submit" type="submit"
					value="submit" /></td>
			</tr>
			<tr>
				<td colspan="2"><input name="reset" type="reset" /></td>
			</tr>
		</table>
	</form>
</body>
</html>