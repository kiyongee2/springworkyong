<%@page import="com.springbook.biz.user.UserVO"%>
<%@page import="java.util.List"%>
<%@page import="com.springbook.biz.board.impl.BoardDAO"%>
<%@page import="com.springbook.biz.board.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	//게시글 번호 추출
	String seq = request.getParameter("seq");

	//DB 연동 처리
	/* BoardVO vo = new BoardVO();
	vo.setSeq(Integer.parseInt(seq)); */
	
	BoardDAO dao = new BoardDAO();
	BoardVO board = dao.getBoard(Integer.parseInt(seq));

%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 목록</title>
</head>
<body>
	<h2>글 상세</h2>
	<h3>
		<a href="logout.jsp">Log-out</a>
	</h3>
	<hr>
	<form action="updateProcess.jsp" method="post">
	<input type="hidden" name="seq" value="<%= board.getSeq() %>">
		<table border="1" style="width:500px">
			<tr>
				<td width="100">제목</td>
				<td align="left"><input type="text" name="title" value="<%= board.getTitle() %>" size=50></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="writer" value="<%= board.getWriter() %>"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="content" cols="50" rows="10"><%=board.getContent() %></textarea></td>
			</tr>
			<tr>
				<td>등록일</td>
				<td><input type="text" name="regdate" value="<%= board.getRegdate() %>"></td>
			</tr>
			<tr>
				<td>조회수</td>
				<td><input type="text" name="cnt" value="<%= board.getCnt() %>"></td>
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
	<a href="deleteProcess.jsp?seq=<%=board.getSeq() %>" 
	   onclick="confirm('정말로 삭제하시겠습니까>')">글삭제</a>
	<a href="getBoardList.jsp">글목록</a>
</body>
</html>