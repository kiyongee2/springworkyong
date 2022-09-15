<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 상세</title>
<link rel="stylesheet" href="/resources/css/style.css">
<script src="https://code.jquery.com/jquery-3.6.1.js" integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI=" crossorigin="anonymous"></script>
</head>
<body>
	<jsp:include page="../menu.jsp" />
	<div id="container">
		<section id="view">
			<div class="title">
				<h2>글 상세보기</h2>
			</div>
			<form action="/board/updateBoard" method="post">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				<!-- 수정 시엔 기본키인 bno를 반드시 명시해 줌 -->
				<input type="hidden" name="bno" value="${board.bno}">
				<!-- 수정, 삭제시 페이지 번호 유지(없으면 1페이지 이동) 및 검색어 유지-->
				<input type="hidden" name="pageNum" value="${cri.pageNum}">
				<input type="hidden" name="amount" value="${cri.amount}">
				<input type="hidden" name="type" value="${cri.type}">
				<input type="hidden" name="keyword" value="${cri.keyword}">
				<table class="tbl_view">
					<tr>
						<td width="100">제목</td>
						<td align="left"><input type="text" name="title" value="${board.title}"></td>
					</tr>
					<tr>
						<td>작성자</td>
						<td><input type="text" name="writer" value="${board.writer}"></td>
					</tr>
					<tr>
						<td>내용</td>
						<td><textarea name="content" cols="80" rows="10">${board.content}</textarea></td>
					</tr>
					<tr>
						<td>등록일</td>
						<td class="time">
							<fmt:formatDate value="${board.regDate}" pattern="yyyy-MM-dd hh:mm:ss"/>
						</td>
					</tr>
					<tr>
						<td>조회수</td>
						<td><input type="text" name="cnt" value="${board.cnt}"></td>
					</tr>
					<tr>
						<td colspan="2" align="center"> 
						<security:authentication property="principal" var="pinfo"/>
						<security:authorize access="isAuthenticated()" >
						<c:if test="${pinfo.username eq board.writer}">
							<input type="submit" value="글 수정">
							<a href="/board/deleteBoard?bno=${board.bno}" 
							   onclick="return confirm('정말로 삭제하시겠습니까>')">
							   <input type="button" value="삭제"></a>
				   		</c:if>
						</security:authorize>
							<a href="/board/boardList"><input type="button" value="목록" class="listBtn"></a>
						</td>
					</tr>
				</table>
			</form>
			<!-- 댓글 영역 -->
			<div class="comment">
			<h4>댓글</h4>
<%-- 			<ol class="replyList">
				<c:forEach items="${replyList}" var="list">
					<li>
						<p>작성자: <c:out value="${list.writer}" /><br>
						   작성일자: <fmt:formatDate value="${list.regDate}" pattern="yyyy-MM-dd hh:mm:ss"/>
						</p>
						<p><c:out value="${list.content}" /></p>
					</li>
				</c:forEach>
			</ol> --%>
			<ul>
				<li>
					<label>작성자</label>
					<input type="text" name="replyer" id="replyer" 
						value='<security:authentication property="principal.username"/>'>
				</li>
				<!-- <li>
					<label>작성일</label>
					<input type="text" name="replyerDate">
				</li> -->
				<li>
					<textarea rows="4" cols="60" name="reply" id="reply"></textarea>
					<button type="button" id="replyBtn">댓글 등록</button>
				</li>
			</ul>
			</div>
			<div class="comment_box"></div>
		</section>
		<form action="/board/boardList" method="get" id="actionForm">
			<input type="hidden" name="bno" value="${board.bno}">
			<input type="hidden" name="pageNum" value="${cri.pageNum}">
			<input type="hidden" name="amount" value="${cri.amount}">
		</form>
	</div>
	<jsp:include page="../footer.jsp" />
<script type="text/javascript"  src="/resources/js/reply.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		// 목록 보기
		let actionForm = $("#actionForm");
		
		$(".listBtn").click(function(e){
			
			e.preventDefault();
			actionForm.submit();
		});
		
		//댓글 등록
		$("#replyBtn").click(function(){
			let bno = '<c:out value="${board.bno}"/>';
			let replyer = $("#replyer").val();
			let reply = $("#reply").val();
			
	 		if(reply == '') {
   				alert('내용을 입력하세요');
   				return;
   			}
			
			$.ajax({
   				type:'post',
   				url: "/replies/insert",
   				data: JSON.stringify(
   					{
   						"bno": bno,
   						"replyer": replyer,
   						"reply": reply
   					}		
   				),
   				contentType: 'application/json',
   				success:function(data){
   					console.log('통신성공' + data);
   					if(data == 'insertSuccess') {
   						alert('댓글 등록이 완료되었습니다.');
   						console.log('댓글 등록 완료');
   						$('#replyer').val(replyer);
   	   					$('#reply').val('');
   	   					getList();   //댓글 목록 호출
   					} else {
   						alert('로그인 이후 이용해주세요.');
   						console.log('댓글 등록 실패');
   					}
   				},
   				error:function(){
   					alert('통신실패');
   				}
   			});// ajax 끝
   			
   			//댓글 등록후 댓글 목록 갱신
   			function getList(){
   				let bno = '<c:out value="${board.bno}"/>';
   				let replyer = $("#replyer").val();
   				let reply = $("#reply").val();
   				
   				$.getJSON(
   					"/replies/getList/" + bno,
   					function(data) {
						let list = data.list;
						
						let reply_html = "<div>";
						
						for(i = 0; i < list.length; i++){
							let replyer = list[i].replyer;  //댓글 작성자
							let reply = list[i].reply;      //댓글 내용
							
							reply_html += "<div><span id='replyer'><strong>" + replyer + "</strong></span><br/>";
							reply_html += "<span id='reply'>" + reply + "</span><br>";
							reply_html += "</div><hr>";
						}
						$(".comment_box").html(reply_html);
   					}
   				);//getJson 끝
   			} //getList 끝
		}); //click 끝
	}); 
</script>

</body>
</html>