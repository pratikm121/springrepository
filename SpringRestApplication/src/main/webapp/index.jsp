<%@ include file="init.jsp" %>
<html>
	<body>
		<h1>Welcome to Spring Rest API Project</h1>
		<a href="${pageContext.request.contextPath}/rest/test">Test Rest API call :- /rest/test</a><br>
		<a href="${pageContext.request.contextPath}/api/students">GET List of students :- /api/students</a><br>	
		<a href="${pageContext.request.contextPath}/api/students/2">GET Student by ID=2 :- /api/students/2</a><br>
		<a href="${pageContext.request.contextPath}/cs/customers">GET List of Customers :- /cs/customers</a><br>
		<a href="${pageContext.request.contextPath}/cs/customers/3">GET Customer by ID=3 :- /cs/customers/3</a><br>  
	</body>
</html>