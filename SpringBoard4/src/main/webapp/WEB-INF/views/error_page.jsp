<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Exception Handling</title>
<link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>
	<div id="container">
		<div class="exception">
			<h2>오류가 발생했습니다.</h2>
			<h3><c:out value="${exception.getMessage()}" /></h3>
		</div>
	</div>
</body>
</html>
