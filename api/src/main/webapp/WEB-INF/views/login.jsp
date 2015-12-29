<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="<c:url value="/css/bootstrap.css" />" media="screen">
		<title>Login Page</title>
	</head>
	<body onload='document.loginForm.username.focus();'>
		<div class="col-md-6">
			<div class="login-panel panel panel-default">
	        	<div class="panel-heading">
	            	<h3 class="panel-title">Sign In</h3>
	            </div>
	            <div class="panel-body">
					<form role="login" action="<c:url value='login' />" method="POST">
						<div class="form-group">
							<input type="text" class="form-control" id="username" name="username" placeholder="Username">
						</div>
						<div class="form-group">
							<input type="password" class="form-control" id="password" name="password" placeholder="Password">
						</div>
						<div class="checkbox">
							<label>
								<input name="remember" type="checkbox" value="Remember Me">Remember Me
							</label>
						</div>
						<div class="form-group">
							<input type="submit" class="submit" value>
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
						</div>
					</form>
				</div>
	        </div>
		</div>
		
		<script src="http://code.jquery.com/jquery.js"></script>
		<script src="<c:url value="/js/bootstrap.js"/>"></script>
	</body>
</html>