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
							<fmt:formatDate value="${board.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
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
				<ol class="replyList">
					<c:forEach items="${replyList}" var="list">
						<li>
							<p class="replyer">작성자: <c:out value="${list.replyer}" />&nbsp;&nbsp;
							   (작성일: <fmt:formatDate value="${list.updateDate}" 
							                    pattern="yyyy-MM-dd hh:mm:ss"/>)
							</p>
							<p><c:out value="${list.reply}" /></p>
							<c:if test="${pinfo.username eq list.replyer}">
							<p>
								<button type="button" class="replyUpdateBtn" data-rno="${list.rno}">수정</button>
								<button type="button" class="replyDeleteBtn" data-rno="${list.rno}">삭제</button>
							</p>
							</c:if>
						</li>
					</c:forEach>
				</ol>
				<!-- 댓글 등록 폼  -->
				<form method="post" id="replyForm" class="replyForm">
					<input type="hidden" name="bno" value="${board.bno}">
					<ul>
						<li>
							<label>작성자</label>
							<input type="text" name="replyer" id="replyer" 
								value='<security:authentication property="principal.username"/>'>
						</li>
						<li>
							<textarea rows="4" cols="60" name="reply" id="reply"></textarea>
							<button type="button" class="replyBtn">댓글 등록</button>
						</li>
					</ul>
				</form>
			</div>
		</section>
		<!-- 페이지 및 검색 전송 폼 -->
		<form action="/board/boardList" method="get" id="actionForm">
			<input type="hidden" name="bno" value="${board.bno}">
			<input type="hidden" name="pageNum" value="${cri.pageNum}">
			<input type="hidden" name="amount" value="${cri.amount}">
			<input type="hidden" name="type" value="${pageMaker.cri.type}">
			<input type="hidden" name="keyword" value="${pageMaker.cri.keyword}">
		</form>
	</div>
	<jsp:include page="../footer.jsp" />
<script type="text/javascript">
	$(document).ready(function(){
		
		let actionForm = $("#actionForm");
		//목록 버튼 클릭
		$(".listBtn").click(function(e){
			
			e.preventDefault();  //없으면 1페이지로 감
			actionForm.submit();
		});
		
		//댓글 등록
		let replyForm = $("#replyForm");
		$(".replyBtn").click(function(e){
			e.preventDefault();
			//console.log("click....");

			replyForm.attr("action", "/board/reply");
			replyForm.submit();
		});
		
		//댓글 삭제 페이지 요청
		$(".replyDeleteBtn").click(function(e){
			e.preventDefault();
			console.log("click....");
			let rno = $(this).attr("data-rno");
			
			location.href = "/board/replyDelete?bno=${board.bno}"
					+ "&rno=" + rno;
		});
		
		//댓글 수정 페이지 요청
		$(".replyUpdateBtn").click(function(e){
			e.preventDefault();
			console.log("click....");
			let rno = $(this).attr("data-rno");
			
			location.href = "/board/replyUpdate?bno=${board.bno}"
					+ "&rno=" + rno;
		});
	});
</script>
</body>
</html>