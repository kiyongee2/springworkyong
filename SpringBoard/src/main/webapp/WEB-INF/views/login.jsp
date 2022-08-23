<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title><spring:message code="message.user.login.title" /></title>
</head>
<body>
	<h2><spring:message code="message.user.login.title" /></h2>
	<p>
		<a href="login.do?lang=en"><spring:message code="message.user.login.language.en" /></a>&nbsp;&nbsp;
		<a href="login.do?lang=ko"><spring:message code="message.user.login.language.ko" /></a>
	</p>
	<hr>
	<form method="post" action="login.do">
	<table border="1">
		<tr>
			<td bgcolor="orange"><spring:message code="message.user.login.id" /></td>
			<td><input type="text" name="id" value="${userVO.id}"></td>
		</tr>
		<tr>
			<td bgcolor="orange"><spring:message code="message.user.login.password" /></td>
			<td><input type="password" name="password" value="${userVO.password}"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
			    <input type="submit" value="<spring:message code='message.user.login.loginBtn'/>">
			</td>
		</tr>
	</table>
	</form>
</body>
</html>