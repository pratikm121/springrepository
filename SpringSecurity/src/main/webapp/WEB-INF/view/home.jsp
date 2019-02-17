<%@ include file="/WEB-INF/view/init.jsp" %>
<html>
	<body>
		<h1>Welcome</h1>
		<div style="margin-bottom: 25px" class="input-group">
			<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span> 
			<p>
				User :- <security:authentication property="principal.username"/>
				<br>
				Roles :- <security:authentication property="principal.authorities"/>
			</p>
		</div>
		<security:authorize access="hasRole('MANAGER')">
			<div style="margin-bottom: 25px" class="input-group">
				<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span> 
				<a href="${pageContext.request.contextPath}/leaders">LeaderShip Meeting</a>
			</div>
		</security:authorize>
		<security:authorize access="hasRole('ADMIN')">
			<div style="margin-bottom: 25px" class="input-group">
				<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span> 
				<a href="${pageContext.request.contextPath}/systems">SysOps Admins Meeting</a>
			</div>
		</security:authorize>
		<form:form action="${pageContext.request.contextPath}/logout" 
				   method="POST">
				   <button type="submit" class="btn btn-success">Logout</button>
		</form:form>				  
	</body>
</html>