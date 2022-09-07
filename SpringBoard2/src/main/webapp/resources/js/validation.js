
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
		type: "post",
		url: "http://localhost:8080/member/checkID",
		dataType: "json",
		data: {"userid": $("#userid").val()},  //서버로 userid 보냄
		success: function(data){ //서버에서 응답 받음
			//console.log(data);
			if(data == 1){
				$("#check").text("이미 가입된 ID입니다.");
				$("#check").css({"color": "red", "padding-top": "5px"});
			}else if(data == 0){
				$("#idCheck").attr("value", "Y");
				$("#check").text("사용 가능한 ID입니다.");
				$("#check").css({"padding-top": "5px"});
			}
		},
		error: function(data){
			alert("에러 발생!!");
		}
	});
}
