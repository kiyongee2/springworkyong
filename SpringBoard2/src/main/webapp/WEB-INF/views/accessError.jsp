<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>access error</title>
<link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>
	<div id="container">
		<section id="login">
			<h1>Access Denied Page</h1>
			
			<h2><c:out value="${msg}" /> </h2>
		</section>
	</div>
</body>
</html>