<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Reference Bootstrap files -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/login.css">

</head>
<body>

    <div class="login-wrapper">

        <div class="login-container">

            <div class="panel panel-default login-panel">

                <div class="panel-heading text-center">
                    <h3 class="panel-title">Welcome Back</h3>
                    <small>Please sign in to continue</small>
                </div>

                <div class="panel-body">

                    <form action="${pageContext.request.contextPath}/authenticateTheUser"
                          method="post">


                        <c:if test="${registered}">
                            <div class="alert alert-success">
                                Registration successful 🎉 Please login.
                            </div>
                        </c:if>

                        <c:if test="${param.error != null}">
                            <div class="alert alert-danger">
                                Invalid username or password
                            </div>
                        </c:if>

                        <c:if test="${param.logout != null}">
                            <div class="alert alert-info">
                                You have been logged out
                            </div>
                        </c:if>

                        <input type="hidden"
                               name="${_csrf.parameterName}"
                               value="${_csrf.token}" />

                        <div class="form-group">
                            <label>Username</label>
                            <input type="text"
                                   name="username"
                                   class="form-control input-lg"
                                   placeholder="Enter username"
                                   required>
                        </div>

                        <div class="form-group">
                            <label>Password</label>
                            <input type="password"
                                   name="password"
                                   class="form-control input-lg"
                                   placeholder="Enter password"
                                   required>
                        </div>

                        <button type="submit"
                                class="btn btn-success btn-lg btn-block">
                            Login
                        </button>
                    </form>

                    <div class="text-center">
                        <p class="text-muted">Don’t have an account?</p>
                        <a href="${pageContext.request.contextPath}/register"
                           class="btn btn-primary btn-lg btn-block">
                            Register New Account
                        </a>
                    </div>

                </div>
            </div>

        </div>
    </div>

</body>
</html>