<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>Index.jsp</h1>
	<div>
		<span>${loginStaff.email}</span>�����ڴ� �ݰ����ϴ� <!--  session_scope ��  �� -->
	</div>
	<div>
		<a href ="${pageContext.request.contextPath}/auth/LogoutServlet">�α׾ƿ�</a> <!--${pageContext.request.contextPath}==request.getcontextPath()  -->
	</div>
	
	
</body>
</html>