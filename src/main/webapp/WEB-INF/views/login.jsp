<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/bootstrap.css" />" media="screen">
    <title>Login Page</title>
</head>
<body onload='document.login.username.focus();' style="background-color: black">

    <div class="container col-sm-offset-5 col-sm-2" style="padding-top: 100px">
        <c:if test="${not empty error}">
            <div class="alert alert-danger">
                <h4>We didn't recognize the username or password you entered. Please try again.</h4>
            </div>
        </c:if>
        <div class="login-panel panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">Sign In</h3>
            </div>
            <div class="panel-body">
                <form class="form-horizontal col-sm-12" id="login" name="login" role="login" action="<c:url value='login'/>" method="POST">
                    <div class="form-group">
                        <input type="text" class="form-control" id="username" name="username" placeholder="Username">
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control" id="password" name="password" placeholder="Password">
                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn btn-default">Sign in</button>
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