<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>로그인</title>
</head>
<body>
	<h2>로그인</h2>
	<hr>
	<form method="post" action="login.do">
	<table border="1">
		<tr>
			<td bgcolor="orange">아이디</td>
			<td><input type="text" name="id"></td>
		</tr>
		<tr>
			<td bgcolor="orange">비밀번호</td>
			<td><input type="password" name="password"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
			    <input type="submit" value="로그인">
			</td>
		</tr>
	</table>
	</form>
</body>
</html>