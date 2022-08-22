<%@page import="com.springbook.biz.board.BoardVO"%>
<%@page import="com.springbook.biz.board.impl.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	//1. 사용자 입력 정보 추출
	String seq = request.getParameter("seq");

	//2. DB 연동
	BoardVO vo = new BoardVO();
	vo.setSeq(Integer.parseInt(seq));

	BoardDAO dao = new BoardDAO();
	dao.deleteBoard(vo);
	
	//화면 이동
	response.sendRedirect("getBoardList.jsp");

%>