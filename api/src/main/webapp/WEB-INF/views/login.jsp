<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="<c:url value="/css/bootstrap.css" />" media="screen">
		<title>Admin Login Page</title>
	</head>
	<body>
		<div class="col-md-6">
			<div class="login-panel panel panel-default">
	        	<div class="panel-heading">
	            	<h3 class="panel-title">Sign In</h3>
	            </div>
	            <div class="panel-body">
					<form role="login" action="<c:url value='j_spring_security_check' />" method="POST">
		                <fieldset>
		                	<div class="form-group">
		                    	<input class="form-control" placeholder="Username" name="username" type="text">
		                    </div>
		                    <div class="form-group">
		                    	<input class="form-control" placeholder="Password" name="password" type="password" value="">
		                    </div>
		                    <div class="checkbox">
		                    	<label>
		                    		<input name="remember" type="checkbox" value="Remember Me">Remember Me
		                    	</label>
		                    </div>
		                    <!-- Change this to a button or input when using this as a form -->
		                    <a href="javascript:;" class="btn btn-sm btn-success">Login</a>
		                    </fieldset>
		                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
 
					</form>
				</div>
	        </div>
		</div>
		
		<script src="http://code.jquery.com/jquery.js"></script>
		<script src="<c:url value="/css/bootstrap.css" />"></script>
	</body>
</html>