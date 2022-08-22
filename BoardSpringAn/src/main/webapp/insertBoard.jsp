<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 등록</title>
</head>
<body>
	<h2>글 등록</h2>
	<hr>
	<form action="insertBoard.do" method="post" enctype="multipart/form-data">
		<table border="1" style="width:500px">
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
				<td>업로드</td>
				<td><input type="file" name="uploadFile"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				    <input type="submit" value="새글 등록">
				</td>
			</tr>
		</table>
	</form>
	<hr>
	<a href="getBoardList.do">글 목록 가기</a>
</body>
</html>