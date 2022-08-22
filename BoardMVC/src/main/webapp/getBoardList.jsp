<%@page import="com.springbook.biz.board.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 목록</title>
</head>
<body>
	<h2>글 목록</h2>
	<h3>
		test님 환영합니다... <a href="logout.do">Log-out</a>
	</h3>
	<!-- 검색 시작 -->
	<form action="getBoardList.jsp" method="post">
		<table border="1" style="width: 500px; text-align:right;">
			<tr>
				<td>
					<select name="searchCondition">
						<option value="TITLE">제목
						<option value="CONTENT">내용
					</select>
					<input type="text" name="searchKeyword">
					<input type="submit" value="검색">
				</td>
			</tr>
		</table>
	</form>
	<!-- 검색 종료 -->
	
	<table border="1" style="width:500px">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>등록일</th>
			<th>조회수</th>
		</tr>
		
		<c:forEach items="${boardList}" var="board">
		<tr>
			<td>${board.seq}</td>
			<td><a href="getBoard.do?seq=${board.seq}">${board.title}</a></td>
			<td>${board.writer}</td>
			<td>${board.regdate}</td>
			<td>${board.cnt}</td>
		</tr>
		</c:forEach>
	</table>
	<p><a href="insertBoard.jsp">새글 등록</a></p>
</body>
</html>