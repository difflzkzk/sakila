<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js">
	$(document).ready(function(){
		$('#loginBtn').click(function(){
			$('#loginForm').submit();
		});
	});
</script>
</head>

	<div>
		오늘 접속자 수 : ${stats.count}
	</div>
	<div>
		총 접속자 수 : ${totalCount}
	</div>
<body>
	<h1>로그인 폼</h1>
	
		<!-- <form id = "loginForm" method="post" action="${pageContext.request.contextPath}/"  id="loginBtn">-->
		<form method="post">
			<div>
				<input type ="text" name ="email" id="email" placeholder="ID" value="aa@ajajaj.com">
			</div>
			<div>
				<input type ="password" name ="password" id="password"  placeholder="PW" value="java1004">
			</div>
			<div>
				<button type ="submit">로그인</button>
			</div>	
		</form>
</body>
</html>