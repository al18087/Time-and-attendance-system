<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	crossorigin="anonymous">
<title>register</title>
</head>
<body class="container">
	<header>
		<h1 class="display-4">新規登録</h1>
	</header>
	<form action="/work/RegisterServlet?action=register" method="post">
		<table class="table">
			<tr>
				<th>氏名</th>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<th>社員番号</th>
				<td><input type="number" name="login_id"></td>
			</tr>
			<tr>
				<th>パスワード</th>
				<td><input type="password" name="password"></td>
			</tr>
		</table>
		<input type="submit" value="登録" class="btn btn-success">
	</form>
</body>
</html>