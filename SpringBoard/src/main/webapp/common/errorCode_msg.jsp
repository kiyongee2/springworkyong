<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기본 에러 화면</title>
<style type="text/css">
	table{
		width: 800px;
		border: 1px solid #ccc;
		border-collaspe: collapse;
		padding: 10px;
		text-align: center;
	}
	.msg td{width: 800px; padding: 20px;}
</style>
</head>
<body>
	<table >
		<tr>
			<td><b>코드 오류가 발생했습니다.</b></td>
		</tr>
	</table>
	<!-- 에러 메시지 -->
	<table class="msg">
		<tr>
			<td>Message : ${exception.message}</td>
		</tr>
	</table>
</body>
</html>