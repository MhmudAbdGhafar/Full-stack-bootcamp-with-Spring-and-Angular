<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/login.css">
</head>
<body>
<div class="login-wrapper">

    <div class="login-container">
        <div class="panel panel-default login-panel">

            <div class="panel-heading text-center">
                <h3 class="panel-title">Create an Account</h3>
            </div>

            <div class="panel-body">
                <form:form action="${pageContext.request.contextPath}/register" modelAttribute="user" method="post">

                    <div class="form-group">
                        <form:label path="username">Username</form:label>
                        <form:input path="username" cssClass="form-control input-lg"/>
                        <form:errors path="username" cssClass="text-danger"/>
                    </div>

                    <div class="form-group">
                        <form:label path="password">Password</form:label>
                        <form:password path="password" cssClass="form-control input-lg"/>
                        <form:errors path="password" cssClass="text-danger"/>
                    </div>

                    <div class="form-group">
                        <form:label path="confirmPassword">Confirm Password</form:label>
                        <form:password path="confirmPassword" cssClass="form-control input-lg"/>
                        <form:errors path="confirmPassword" cssClass="text-danger"/>
                    </div>

                    <div class="form-group">
                        <form:label path="firstName">First Name</form:label>
                        <form:input path="firstName" cssClass="form-control input-lg"/>
                        <form:errors path="firstName" cssClass="text-danger"/>
                    </div>

                    <div class="form-group">
                        <form:label path="lastName">Last Name</form:label>
                        <form:input path="lastName" cssClass="form-control input-lg"/>
                        <form:errors path="lastName" cssClass="text-danger"/>
                    </div>

                    <div class="form-group">
                        <form:label path="email">Email</form:label>
                        <form:input path="email" cssClass="form-control input-lg"/>
                        <form:errors path="email" cssClass="text-danger"/>
                    </div>

                    <button type="submit" class="btn btn-success btn-lg btn-block">Register</button>
                </form:form>

                <c:if test="${not empty error}">
                    <div class="alert alert-danger" style="margin-top: 15px;">
                            ${error}
                    </div>
                </c:if>

            </div>
        </div>
    </div>
</div>
</body>
</html>