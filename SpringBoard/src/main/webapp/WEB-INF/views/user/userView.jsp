<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보</title>
<link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>
	<div id="container">
		<div class="title">
			<h1>회원 정보</h1>
		</div>
		<div>
			<form action="/user/update" method="post">
			<table class="tbl_signup">
				<tr>
					<td>아이디</td>
					<td><input type="text" name="userid" value="${user.id}" 
						       readonly="readonly"></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="passwd" value="${user.passwd}"></td>
				</tr>
				<tr>
					<td>비밀번호 확인</td>
					<td><input type="password" name="passwd_confirm" value="${user.passwd}"></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="name" value="${user.name}"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"> 
						<input type="submit" value="수정">
						<a href="/user/delete?id=${user.id}" 
						   onclick="return confirm('정말로 삭제하시겠습니까>')">
						   <input type="button" value="삭제"></a>
						<a href="/user/userList"><input type="button" value="목록"></a>
					</td>
				</tr>
			</table>
		</form>
		</div>
	</div>
</body>
</html>