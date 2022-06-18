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
<title>login</title>
</head>
<body class="container">
	<header>
		<h1 class="display-4">ログイン</h1>
	</header>
	<form action="/work/LoginServlet?action=login" method="post">
		<br>
		<h6>IDとパスワードを入力してください。</h6>
		<h4 class="text-danger">${message}</h4>
		<br>
		<table class="table">
			<tr>
				<th>社員番号</th>
				<td><input type="number" name="login_id"></td>
			</tr>
			<tr>
				<th>パスワード</th>
				<td><input type="password" name="password"></td>
			</tr>
		</table>
		<input type="submit" value="ログイン" class="btn btn-success">
	</form>
	<br>
	<h6>
		<a href="/work/register.jsp" class="text-success">新規登録</a>
	</h6>
</body>
</html>