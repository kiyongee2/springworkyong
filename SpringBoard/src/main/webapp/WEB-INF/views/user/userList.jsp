<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>
<link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>
	<div id="container">
		<section id="list">
			<div class="title">
				<h2>회원 목록</h2>
			</div>
			<table class="tbl_list">
				<thead>
					<tr>
						<th>아이디</th>
						<th>비밀번호</th>
						<th>이 름</th>
						<th>권한(등급)</th>
					</tr>
				<thead>
				<tbody>
					<c:forEach items="${userList}" var="user" >
					<tr>
						<td><a href='/user/userView?id=<c:out value="${user.id}"/>'><c:out value="${user.id}" /></a></td>
						<td><c:out value="${user.passwd}" />  </td>
						<td><c:out value="${user.name}" />  </td>
						<td><c:out value="${user.role}" />  </td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</section>
	</div>
</body>
</html>