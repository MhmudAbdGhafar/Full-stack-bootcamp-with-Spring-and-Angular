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

    <h2>Hello in Admin Page <security:authentication property="principal.username" /></h2>
    <h4>You have roles: <security:authentication property="principal.authorities"/> </h4>

    <form:form action="${pageContext.request.contextPath}/logout" method="post">
        <input type="submit" class="btn btn-danger" value="Logout">
    </form:form>

</div>

</body>
</html>