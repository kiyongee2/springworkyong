<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>
<link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>
	<jsp:include page="../menu.jsp" />
	<div id="container">
		<section id="list">
			<div class="title">
				<h2>회원 목록</h2>
			</div>
			<table class="tbl_list">
				<thead>
					<tr>
						<th>아이디</th><th>이름</th><th>가입일</th><th>권한</th>
					</tr>
				<thead>
				<tbody>
					<c:forEach items="${memberList}" var="member" >
					<tr>
						<td><a href='/member/memberView?userid=<c:out value="${member.userid}"/>'>
							<c:out value="${member.userid}" /></a>
						</td>
						<td><c:out value="${member.username}" />  </td>
						<td><fmt:formatDate value="${member.regDate}" pattern="yyyy/mm/dd hh:mm:ss" /></td>
						<%-- <td><c:out value="${member.authList.get(0)}" /></td> --%>
						<%-- <td><c:out value="${fn:split(member.authList.get(0), '=')[2]}" /></td> --%>
						<td><c:out value="${fn:replace(fn:split(member.authList.get(0), '=')[2], ')', '')}" /></td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</section>
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>