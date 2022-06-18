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
<title>register finish</title>
</head>
<body class="container">
	<header>
		<h1 class="display-4">登録完了</h1>
	</header>
	<h6>登録完了しました。以下の内容があなたの個人情報です。</h6>
	<form action="/work/RegisterServlet?action=login" method="post">
		<table class="table">
			<tr>
				<th>氏名</th>
				<td>${register.name}</td>
				<td><input type="hidden" name="name" value="${register.name}"></td>
			</tr>
			<tr>
				<th>社員番号</th>
				<td>${register.loginId}</td>
				<td><input type="hidden" name="login_id"
					value="${register.loginId}"></td>
			</tr>
			<tr>
				<th>パスワード</th>
				<td>パスワードをお見せすることはできません。</td>
				<td><input type="hidden" name="password"
					value="${register.password}"></td>
			</tr>
		</table>
		<input type="submit" value="ログイン" class="btn btn-success">
	</form>
</body>
</html>