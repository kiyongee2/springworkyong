<%@page import="com.springbook.biz.board.BoardVO"%>
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
	<h2>글 상세</h2>
	<h3>
		<a href="logout.do">Log-out</a>
	</h3>
	<hr>
	<form action="updateBoard.do" method="post">
	<input type="hidden" name="seq" value="${board.seq}">
		<table border="1" style="width:500px">
			<tr>
				<td width="100">제목</td>
				<td align="left"><input type="text" name="title" value="${board.title}" size=50></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="writer" value="${board.writer}"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="content" cols="50" rows="10">${board.content}</textarea></td>
			</tr>
			<tr>
				<td>등록일</td>
				<td><input type="text" name="regdate" value="${board.regdate}"></td>
			</tr>
			<tr>
				<td>조회수</td>
				<td><input type="text" name="cnt" value="${board.cnt}"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				    <input type="submit" value="글 수정">
				</td>
			</tr>
		</table>
	</form>
	<hr>
	<a href="insertBoard.jsp">글등록</a>
	<a href="deleteBoard.do?seq=${board.seq}" 
	   onclick="confirm('정말로 삭제하시겠습니까>')">글삭제</a>
	<a href="getBoardList.do">글목록</a>
</body>
</html>