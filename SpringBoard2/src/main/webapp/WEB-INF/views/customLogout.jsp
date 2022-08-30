<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- <%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일반 로그인</title>
</head>
<body>
	<div id="container">
		<section id="login">
			<h1>Logout Page</h1>
			
			<h2><c:out value="${error}" /></h2>
			<h2><c:out value="${logout}" /> </h2>
			
			<form action="/customLogout" method="post" >
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				<button type="submit">로그아웃</button>
			</form>
		</section>
	</div>
</body>
</html>