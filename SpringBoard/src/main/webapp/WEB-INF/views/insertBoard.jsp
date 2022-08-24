<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 등록</title>
<link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>
	<div id="container">
		<section id="register">
			<h2>글 등록</h2>
			<hr>
			<form action="/insertBoard" method="post">
				<table class="tbl_reg">
					<tr>
						<td width="100">제목</td>
						<td align="left"><input type="text" name="title" size="50"></td>
					</tr>
					<tr>
						<td>작성자</td>
						<td><input type="text" name="writer"></td>
					</tr>
					<tr>
						<td>내용</td>
						<td><textarea name="content" cols="50" rows="10"></textarea></td>
					</tr>
					<tr>
						<td colspan="2" align="center">
						    <input type="submit" value="등록">
						    <a href="/boardList"><input type="button" value="목록"></a>
						</td>
					</tr>
				</table>
			</form>
		</section>
	</div>
</body>
</html>