<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>myPort.jsp</h1> <!-- 내정보 페이지 -->
	<div>
		<span>${loginStaff.email}</span>관리자님 반갑습니다 <!--  session_scope 생  략 -->
	</div>
	
	<div>
		<a href ="${pageContext.request.contextPath}/auth/LogoutServlet">로그아웃</a> <!--${pageContext.request.contextPath}==request.getcontextPath()  -->
	</div>
	
	<div>
				<button type ="submit">정보수정</button>
	</div>	
</body>
</html>