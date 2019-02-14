<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<title>Spring Security Custom Login Form</title>
	</head>
	<body>
		<h3>Custom Login Form</h3>
		<form:form action="${pageContext.request.contextPath}/authenticateUser" method = "POST">
		<c:if test= "${param.error != null}">
			<i>Sorry ! You entered invalid values</i>
		</c:if>
		<p>User Name :- <input type= "text" name = "username"/></p>
		<p>Password :- <input type= "password" name = "password"/></p>
		<input type= "submit" value = "Login"/>
		</form:form>
	</body>
</html>