<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
<link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>
	<div id="container">
		<div class="title">
			<h1>회원 가입</h1>
		</div>
		<div>
			<form action="/member/insertMember" method="post" name="regForm">
			<table class="tbl">
				<tr>
					<td>아이디</td>
					<td><input type="text" name="memberId" placeholder="ID"></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="passwd" placeholder="PASSWORD"></td>
				</tr>
				<tr>
					<td>비밀번호 확인</td>
					<td><input type="password" name="passwd_confirm" placeholder="PASSWORD_CONFIRM"></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td>성별</td>
					<td>
						<select name="gender">
							<option selected>남</option>
							<option>여</option>
						</select>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="등록" onclick="checkMember()">
						<input type="reset" value="취소">
					</td>
				</tr>
			</table>
		</form>
		</div>
	</div>
</body>
</html>