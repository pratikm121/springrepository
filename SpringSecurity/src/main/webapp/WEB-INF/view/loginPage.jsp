<%@ include file="/WEB-INF/view/init.jsp" %>
<html>
	<head>
		<title>My Spring Security Custom Login Form</title>
	</head>
	<body>
		<div class = "box">
			<h3>Custom Login Form</h3>
			<form:form action="${pageContext.request.contextPath}/authenticateUser" method = "POST">
			<c:if test= "${param.error != null}">
				<i>Sorry ! You entered invalid values</i>
			</c:if>
			<div class = "inputBox">
				<input type ="text" name = "username" required = "">
				<label>Username</label>
			</div>
			<div class = "inputBox">
				<input type ="password" name = "password" required = "">
				<label>Password</label>
			</div>
			<input type ="submit" name = "" value = "Login">
			</form:form>
		</div>
	</body>
</html>