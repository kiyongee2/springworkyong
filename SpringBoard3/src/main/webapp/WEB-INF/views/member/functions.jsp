<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>
		<c:set var="text" value="${fn:split('Hello, Java Server Page', ' ')}" />
		<p><c:out value="${fn:split('Hello, Java Server Page', ' ')[0]}" />
		<p><c:out value="${text[0]}" /> <c:out value="${text[1]}" /> </p>
		<p>문자열의 개수 : ${fn: length(text)}
		<p><c:forEach begin="0" end="${fn: length(text)}" var="i">
			<c:out value="${text[i]}" />
		</c:forEach>
		
	</p>
</body>
</html>