<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 상세</title>
<link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>
	<div id="container">
		<section id="list">
			<h2>글 상세 보기</h2>
			<form action="/updateBoard" method="post">
			<!-- 수정 시엔 기본키인 bno를 반드시 명시해 줌 -->
			<input type="hidden" name="bno" value="${board.bno}">
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
							<input type="submit" value="글 수정">
							<a href="/deleteBoard?bno=${board.bno}" 
							   onclick="return confirm('정말로 삭제하시겠습니까>')">
							   <input type="button" value="삭제"></a>
							<a href="/boardList"><input type="button" value="목록"></a>
						</td>
					</tr>
				</table>
			</form>
		</section>
	</div>
</body>
</html>