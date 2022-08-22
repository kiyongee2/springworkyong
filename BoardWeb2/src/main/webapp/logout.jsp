<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//세션 객체 종료
	session.invalidate();

	response.sendRedirect("login.jsp");
%>