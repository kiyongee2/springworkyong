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
		<section id="list">
			<div class="title">
				<h2>글 상세보기</h2>
			</div>
			<form action="/board/updateBoard" method="post">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				<!-- 수정 시엔 기본키인 bno를 반드시 명시해 줌 -->
				<input type="hidden" name="bno" value="${board.bno}">
				<!-- 수정, 삭제시 페이지 번호 유지(없으면 1페이지 이동) -->
				<input type="hidden" name="pageNum" value="${cri.pageNum}">
				<input type="hidden" name="amount" value="${cri.amount}">
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
						<td><textarea name="content" cols="62" rows="10">${board.content}</textarea></td>
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
							   onclick="return confirm('정말로 삭제하시겠습니까?')">
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
				<button id="replyBtn" class="replyBtn">댓글 쓰기</button>
				<ul class="chat">
					<li class="left" data-rno='12'>
						<strong>user00</strong>
						<small class="right">2022-09-15 05:03</small>
						<p>Good job!</p>
					</li>
				</ul>
			</div>
		</section>
		<form action="/board/boardList" method="get" id="actionForm">
			<input type="hidden" name="bno" value="${board.bno}">
			<!-- 목록 페이지로 이동시 페이지 번호 유지(없으면 1페이지로 감) -->
			<input type="hidden" name="pageNum" value="${cri.pageNum}">
			<input type="hidden" name="amount" value="${cri.amount}">
		</form>
	</div>
	<jsp:include page="../footer.jsp" />
<script type="text/javascript" src="/resources/js/reply.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		
		let actionForm = $("#actionForm");
		//목록 버튼 클릭
		$(".listBtn").click(function(e){
			
			e.preventDefault();  //없으면 1페이지로 감
			actionForm.submit();
		});
	});
	
	$(document).ready(function(){
		
		console.log(replyService);
		
		let bnoValue = '<c:out value="${board.bno}" />';
		let replyUL = $(".chat");
		
		showList(1);  //파라미터가 없는 경우 1 page
		
		function showList(page){
			replyService.getList({bno:bnoValue, page|| 1}, function(list){
				let str="";
				if(list == null || list.length == 0){
					replyUL.html("");
					return;
				}
				for(var i=0; len=list.length||0; i<len, i++){
					str += "<li class='left' data-rno='"+list[i].rno+"'>";
					str += "<strong>"+list[i].replyer+"</strong>";
					str += "<small class='right'>"+list[i].replyDate+"</small>";
					str += "<p>"+list[i].reply+"</p></li>"
				}
				
				replyUL.html(str);
				
			}); //function end
		}//showList end
		
		//댓글 등록
		/*replyService.add(
			{reply: "JS TEST", replyer: "tester", bno: bnoValue},
			function(result){
				alert("RESULT: " + result);
			}
		);*/
		
		//댓글 목록
		replyService.getList({bno:bnoValue, page:1}, function(list){
			for(var i=0; len=list.length||0; i<len, i++){
				console.log(list[i]);
			}
		});
	});
</script>
</body>
</html>