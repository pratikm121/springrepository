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
		<div style="margin-bottom: 25px" class="input-group">
			<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span> 
			<a href="${pageContext.request.contextPath}/leaders">LeaderShip Meeting</a>
		</div>
		
		<form:form action="${pageContext.request.contextPath}/logout" 
				   method="POST">
				   <button type="submit" class="btn btn-success">Logout</button>
		</form:form>				  
	</body>
</html>