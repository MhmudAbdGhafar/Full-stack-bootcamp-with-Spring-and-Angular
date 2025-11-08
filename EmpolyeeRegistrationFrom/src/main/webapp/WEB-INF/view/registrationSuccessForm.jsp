<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Registration Success</title>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">

</head>

<body>
<div class="container">
    <div class="card mx-auto mt-5" style="max-width: 500px;">
        <div class="card-header text-center">
            Registration Successful
        </div>
        <div class="card-body text-center">
            <h5 class="text-success mb-4">Employee Registered Successfully!</h5>

            <table class="table table-bordered text-left">
                <tr><th>Username</th><td>${employee.userName}</td></tr>
                <tr><th>Email</th><td>${employee.email}</td></tr>
            </table>

            <a href="<c:url value='/'/>" class="btn btn-primary mt-3">
                Register Another
            </a>
        </div>
    </div>
</div>
</body>
</html>