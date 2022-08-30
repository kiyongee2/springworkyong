<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>
<link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>
		<div id="container">
		<div class="title">
			<h1>회원 목록</h1>
		</div>
		<div>
		<form>
			<table class="tbl_list">
				<thead>
					<tr>
						<th>아이디</th>
						<!-- <th>비밀번호</th> -->
						<th>이름</th>
						<th>가입일</th>
					</tr>
				<thead>
				<tbody>
					<c:forEach items="${memberList}" var="member">
					<tr>
						<td><c:out value="${member.userid}" /></td>
						<%-- <td><c:out value="${member.userpw}" /></td> --%>
						<td><c:out value="${member.userName}" /></td>
						<td><c:out value="${member.regDate}" /></td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</form>
		</div>
	</div>
</body>
</html>