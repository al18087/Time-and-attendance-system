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
<title>work</title>
</head>
<body class="container">
	<header>
		<h1 class="display-4">勤怠システム</h1>
	</header>
	<hr>
	<h2>${login.name}さん、こんにちは！</h2>
	<hr>
	<a href="/work/LoginServlet?action=logout" class="text-success"
		style="font-size: 20px;">ログアウト</a>
	<hr>
	<form action="/work/WorkServlet?action=search_calendar" method="post">
		閲覧したいカレンダーを選択　
		<select name="year" style="font-size : 20px;">
			<c:forEach items="${yearList}" var="year">
				<option value="${year}">${year}
			</c:forEach>

		</select> 
		年　
		<select name="month" style="font-size : 20px;">
			<c:forEach items="${monthList}" var="month">
				<option value="${month}">${month}
			</c:forEach>
		</select>
		月　
		<input type="submit" value="検索" class="btn btn-success">
	</form>
	<hr>
	<h2>${year_and_month.year}年　${year_and_month.month}月</h2>
	<table class="table">
		<tr>
			<th>日</th>
			<th>曜日</th>
			<th>勤務時間入力</th>
		</tr>
		<c:forEach items="${calendar}" var="item">
			<c:choose>
			
				<c:when test="${item.dayOfWeek eq 'SATURDAY'}">
					<form
						action="/Work/ScheduleServlet?action=schedule&year=${item.year}&month=${item.monthValue}&day=${item.dayOfMonth}"
						method="post">
					<tr class="table-info">
						<th>${item.dayOfMonth}</th>
						<th>${item.dayOfWeek}</th>
						<th><input type="submit" value="入力" class="btn btn-success"></th>
					</tr>
					</form>
				</c:when>
				
				<c:when test="${item.dayOfWeek eq 'SUNDAY'}">
					<form
						action="/Work/ScheduleServlet?action=schedule&year=${item.year}&month=${item.monthValue}&day=${item.dayOfMonth}"
						method="post">
						<tr class="table-danger">
							<th>${item.dayOfMonth}</th>
							<th>${item.dayOfWeek}</th>
							<th><input type="submit" value="入力" class="btn btn-success"></th>
						</tr>
					</form>
				</c:when>
				
				<c:otherwise>
					<form
						action="/Work/ScheduleServlet?action=schedule&year=${item.year}&month=${item.monthValue}&day=${item.dayOfMonth}"
						method="post">
						<tr>
							<th>${item.dayOfMonth}</th>
							<th>${item.dayOfWeek}</th>
							<th><input type="submit" value="入力" class="btn btn-success"></th>
						</tr>
					</form>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</table>
</body>
</html>