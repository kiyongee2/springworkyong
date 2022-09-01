<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>
	<jsp:include page="./menu.jsp" />
	<div id="container">
		<section id="login">
			<div class="title">
				<h2>로그인</h2>
			</div>
			<c:if test="${error==1}">
				<p class="error"><c:out value="아이디나 비밀번호를 확인해주세요." /></p>
			</c:if>
			<form action="/customLogin" method="post">
				<table class="tbl_login">
					<tr>
						<td>아이디</td>
						<td><input type="text" name="userid" required="required"></td>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td><input type="password" name="userpw" required="required"></td>
					</tr>
					<tr>
						<td colspan="2">
						<button type="submit">로그인</button>
					</tr>
				</table>
			</form>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</section>
	</div>
	<jsp:include page="./footer.jsp" />
</body>
</html>