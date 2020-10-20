<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>

	<div>
		오늘 접속자수 : ${stas.count} <!-- 오늘의 접속자 수  ${map["stats"].count} // 전체 접속자 수 : ${map["totalCount"]}-->
	</div>
<body>
	<h1>로그인 폼</h1>
		<form>
			<div>
				<input type ="text" placeholder="ID">
			</div>
			<div>
				<input type ="password" placeholder="PW">
			</div>
			<div>
				<button type ="button">로그인</button>
			</div>	
		</form>
</body>
</html>