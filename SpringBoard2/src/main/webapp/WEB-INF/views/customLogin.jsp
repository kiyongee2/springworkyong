<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일반 로그인</title>
</head>
<body>
	<h1>Custom Login Page</h1>
	
	<h2><c:out value="${error}" /></h2>
	<h2><c:out value="${logout}" /> </h2>
	
	<form method="post" action="/login">
		<div>
			<input type="text" name="username" placeholder="ID" autofocus>
		</div>
		<div>
			<input type="password" name="password" placeholder="Password">
		</div>
		<div>
			<a href="index.jsp"><button type="submit">로그인</button></a>
		</div>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>
</body>
</html>