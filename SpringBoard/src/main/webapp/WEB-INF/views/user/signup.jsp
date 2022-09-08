<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
<link rel="stylesheet" href="/resources/css/style.css">
<script src="https://code.jquery.com/jquery-3.6.1.js" integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI=" crossorigin="anonymous"></script>
<script>
function checkID(){
	//alert("check");
	let t_id = $("#t_id").val();
	$.ajax({
		type: "get",
		url: "/user/checkID",
		dataType: "json",
		async: false,
		data: {"id": t_id},  //서블릿쪽으로 id 보냄
		success: function(data){ //서블릿에서 응답 받음
			console.log(data);
			
			if(data == 1){
				$("#check").text("이미 가입된 ID입니다.");
				$("#check").css({"color": "red", "padding-top": "5px"});
			}else{
				$("#check").text("사용 가능한 ID입니다.");
				$("#check").css({"padding-top": "5px"});
			}
		},
		error: function(data){
			alert("에러 발생!!");
		}
	});
}
</script>
</head>
<body>
	<div id="container">
		<div class="title">
			<h1>회원 가입</h1>
		</div>
		<div>
			<form action="/user/signup" method="post" name="regForm"
			      onsubmit="return checkForm()">
			<table class="tbl_signup">
				<tr>
					<td>아이디</td>
					<td class="t_id">
						<input type="text" id="t_id" name="id" placeholder="ID">
						<button type="button" id="idCheck" value="N" 
						        onclick="checkID()">ID 중복</button>
						<p id="check"></p>
					</td>
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
					<td colspan="2">
						<input type="submit" value="등록">
						<input type="reset" value="취소">
					</td>
				</tr>
			</table>
		</form>
		</div>
	</div>
</body>
</html>