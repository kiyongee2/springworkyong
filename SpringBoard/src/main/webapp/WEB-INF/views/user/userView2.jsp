<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 정보</title>
<link rel="stylesheet" href="/resources/css/style.css">
<script>
	function checkView(){
		let form = document.viewForm;
		let pwd1 = form.userpw.value;
		let pwd2 = form.userpw_confirm.value;
		
		if(pwd1 != pwd2){
			alert("비밀번호를 동일하게 입력하세요");
			form.userpw_confirm.select();
			return false;
		}else{
			form.submit();
		}
	}
</script>
</head>
<body>
	<div id="container">
		<div class="title">
			<h1>나의 정보</h1>
		</div>
		<div>
			<form action="/user/update" method="post" name="viewForm"
			      onsubmit="return checkView()">
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
						<a href="/user/delete?id=${member.userid}" 
						   onclick="return confirm('정말로 탈퇴하시겠습니까>')">
						   <input type="button" value="탈퇴"></a>
						<a href="/user/userList"><input type="button" value="목록"></a>
					</td>
				</tr>
			</table>
		</form>
		</div>
	</div>
</body>
</html>