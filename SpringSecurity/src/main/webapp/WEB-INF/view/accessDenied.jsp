<%@ include file="/WEB-INF/view/init.jsp" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Spring Security Access Denied</title>
</head>
<body>
	<h1>Access Denied - You {<security:authentication property="principal.username"/>}
		Don't have the role {<security:authentication property="principal.authorities"/>}
		to view this page.
	</h1>
	<a href="${pageContext.request.contextPath}/">Home page</a>
</body>
</html>