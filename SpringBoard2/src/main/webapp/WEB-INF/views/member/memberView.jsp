<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
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
		}
	}
</script>
</head>
<body>
	<jsp:include page="../menu.jsp" />
	<div id="container">
		<div class="title">
			<h1>나의 정보</h1>
		</div>
		<div>
			<form action="/member/update" method="post" name="viewForm"
			      onsubmit="return checkView()">
			<table class="tbl_signup">
				<tr>
					<td>아이디</td>
					<td><input type="text" name="userid" value="${member.userid}" 
						       readonly="readonly"></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="userpw" value="${member.userpw}"></td>
				</tr>
				<tr>
					<td>비밀번호 확인</td>
					<td><input type="password" name="userpw_confirm" value="${member.userpw}"></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="username" value="${member.username}"></td>
				</tr>
				<tr>
					<td>가입일</td>
					<td class="time">
						<fmt:formatDate value="${member.regDate}" pattern="yyyy-MM-dd hh:mm:ss"/>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center"> 
						<input type="submit" value="수정">
						<a href="/member/delete?userid=${member.userid}" 
						   onclick="return confirm('정말로 탈퇴하시겠습니까>')">
						   <input type="button" value="탈퇴"></a>
						<a href="/member/memberList"><input type="button" value="목록"></a>
					</td>
				</tr>
			</table>
		</form>
		</div>
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>