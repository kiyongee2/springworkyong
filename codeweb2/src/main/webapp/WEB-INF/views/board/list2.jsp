<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>목록 페이지</title>
</head>
<body>
	<h1>List 페이지</h1>
	<p>${list}</p>
	<c:forEach var="list" items="${boardList }">
		<%-- ${list }<br> --%>
		<c:out value="${list }"></c:out><br>
	</c:forEach>
</body>
</html>