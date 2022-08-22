<%@page import="com.springbook.biz.user.UserVO"%>
<%@page import="java.util.List"%>
<%@page import="com.springbook.biz.board.impl.BoardDAO"%>
<%@page import="com.springbook.biz.board.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	//DB 연동 처리
	BoardVO vo = new BoardVO();
	BoardDAO dao = new BoardDAO();
	List<BoardVO> boardList = dao.getBoardList();

%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 목록</title>
</head>
<body>
	<h2>글 목록</h2>
	<h3>
		test님 환영합니다... <a href="logout.jsp">Log-out</a>
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
		<% for(BoardVO board : boardList){ %>
		<tr>
			<td><%= board.getSeq() %></td>
			<td><a href="getBoard.jsp?seq=<%=board.getSeq() %>"><%=board.getTitle() %></a></td>
			<td><%= board.getWriter() %></td>
			<td><%= board.getRegdate() %></td>
			<td><%= board.getCnt() %></td>
		</tr>
		<% } %>
	</table>
	<p><a href="insertBoard.jsp">새글 등록</a></p>
</body>
</html>