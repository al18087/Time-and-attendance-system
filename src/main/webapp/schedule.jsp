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
<title>schedule</title>
</head>
<body class="container">
	<header>
		<h1 class="display-4">勤怠登録</h1>
	</header>
	<form action="/work/ScheduleServlet?action=schedule_register" method="post">
		<table class="table">
			<tr>
				<th style="font-size: 40px;">${items.year}/${items.month}/
					${items.day}</th>
			</tr>
			<tr>
				<th>勤務体系</th>
				<th><select name="service_system">
						<option value="go_to_work">出勤
						<option value="behind_work">遅刻
						<option value="leave_early">早退
						<option value="telework">テレワーク
				</select></th>
			</tr>
			<tr>
				<th>勤務開始時刻</th>
				<th><input type="number" name="start_hour"> : <input
					type="number" name="start_minute"></th>
			</tr>
			<tr>
				<th>勤務終了時刻</th>
				<th><input type="number" name="finish_hour"> : <input
					type="number" name="finish_minute"></th>
			</tr>
		</table>
		<input type="submit" value="登録" class="btn btn-success">
	</form>
</body>
</html>