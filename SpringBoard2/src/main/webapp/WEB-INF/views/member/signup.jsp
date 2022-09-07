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
<script src="https://code.jquery.com/jquery-3.6.1.js" integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI=" crossorigin="anonymous"></script>
<script src="/resources/js/validation.js"></script>
<script>
function checkForm(){
	//alert("test");
	let id = document.getElementById("userid");
	let pwd1 = document.getElementById("userpw");
	let pwd2 = document.getElementById("userpw_confirm");
	let name = document.getElementById("username");
	let idChkVal = document.getElementById("idCheck");
	
	//정규식 변수 할당
	let regExpId = /^[a-zA-Z0-9]*$/ //영문자, 숫자만(^-시작, *-반복)
	let regExpPwd1 = /[a-zA-Z0-9]/  //영문자, 숫자
	let regExpPwd2 = /[~!@#$%^&*()_+/]/  //특수문자
	let regExpPwd3 = /[ㄱ-ㅎㅏ-ㅣ가-힣]/  //한글
	
	if(id.value.length < 4 || id.value.length > 12 || !regExpId.test(id.value)){
		alert("아이디는 영문자, 숫자 포함 4-12자 이하로 입력해주세요 ");
		userid.focus();
		userid.select();
		return false;
	}
	if(pwd1.value.length < 8 || pwd1.value.length > 12 || !regExpPwd1.test(pwd1.value)
			|| !regExpPwd2.test(pwd1.value) || regExpPwd3.test(pwd1.value)){
		alert("비밀번호는 영문자, 숫자, 특수문자 포함 8-12자 이하로 입력해주세요 ");
		userpw.focus();
		userpw.select();
		return false;
	}
	if(pwd1.value != pwd2.value){
		alert("비밀번호를 동일하게 입력해주세요");
		userpw_confirm.select();
		return false;
	}
	if(name.value == ""){
		alert("이름을 입력해주세요");
		username.focus();
		return false;
	}
	if(idChkVal.value == "N"){
		alert("아이디 중복 확인을 해주세요");
		return false;
	}
}

function checkID(){
	$.ajax({
		type: "get",
		url: "http://localhost:8080/member/checkID",
		dataType: "json",
		data: {"userid": $("#userid").val()},  //서버로 userid 보냄
		success: function(data){ //서버에서 응답 받음
			//console.log(data);
			if(data == 1){
				$("#check").text("이미 가입된 ID입니다.");
				$("#check").css({"color": "red", "padding-top": "5px"});
			}else if(data == 0){
				$("#idCheck").attr("value", "Y");  //버튼의 value를 "Y"로 변경
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
	<jsp:include page="../menu.jsp" />
	<div id="container">
		<div class="title">
			<h1>회원 가입</h1>
		</div>
		<div>
		<form action="/member/signup" method="post" id="regForm" name="regForm"
		      onsubmit="return checkForm()">
			<table class="tbl_signup">
				<tr>
					<td>아이디</td>
					<td>
						<input type="text" id="userid" name="userid" placeholder="ID">
						<button type="button" id="idCheck" value="N" onclick="checkID()">ID 중복</button>
						<p id="check"></p>
					</td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" id="userpw" name="userpw" placeholder="PASSWORD"></td>
				</tr>
				<tr>
					<td>비밀번호 확인</td>
					<td><input type="password" id="userpw_confirm" name="userpw_confirm" placeholder="PASSWORD_CONFIRM"></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" id="username" name="username"></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="등록" >
						<input type="button" value="취소" >
					</td>
				</tr>
			</table>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>
		</div>
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>