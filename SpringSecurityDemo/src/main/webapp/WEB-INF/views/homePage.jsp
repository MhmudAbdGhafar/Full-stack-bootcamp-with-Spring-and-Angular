<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Home Page</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/home.css">

</head>
<body>

<div class="home-wrapper">

    <h2>Hello <security:authentication property="principal.username" /></h2>
    <h4>You have roles: <security:authentication property="principal.authorities"/> </h4>

    <security:authorize access="hasRole('ADMIN')">
        <a href="${pageContext.request.contextPath}/admin" class="btn btn-info">Admin Page</a>
    </security:authorize>

    <security:authorize access="hasRole('SYSTEM')">
        <a href="${pageContext.request.contextPath}/system" class="btn btn-info">System Page</a>
    </security:authorize>

    <form:form action="${pageContext.request.contextPath}/logout" method="post">
        <input type="submit" class="btn btn-danger" value="Logout">
    </form:form>

</div>

</body>
</html>