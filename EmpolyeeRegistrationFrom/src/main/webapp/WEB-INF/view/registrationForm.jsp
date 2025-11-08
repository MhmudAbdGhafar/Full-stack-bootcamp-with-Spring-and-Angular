<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Employee Registration</title>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">

    <style>
        body {
            background: linear-gradient(120deg, #f0f9ff, #ffffff);
            font-family: 'Poppins', sans-serif;
        }

        .card {
            border-radius: 15px;
            box-shadow: 0 8px 20px rgba(0, 0, 0, 0.1);
        }

        .card-header {
            background-color: #007bff;
            color: white;
            font-weight: 600;
            border-top-left-radius: 15px;
            border-top-right-radius: 15px;
        }

        .btn-primary {
            border-radius: 8px;
            font-weight: 600;
        }
    </style>

</head>

<body>
    <div class="container">
        <div class="card mx-auto mt-5" style="max-width: 500px;">
            <div class="card-header text-center">
                Employee Registration
            </div>
            <div class="card-body">
                <form:form modelAttribute="employee" action="registerEmployee">

                    <div class="form-group">
                        <label for="userName">Username</label>
                        <form:input path="userName" cssClass="form-control" id="userName"/>
                        <form:errors path="userName" cssClass="text-danger small" />
                    </div>

                    <div class="form-group">
                        <label for="email">Email</label>
                        <form:input path="email" cssClass="form-control" id="email"/>
                        <form:errors path="email" cssClass="text-danger small" />
                    </div>

                    <div class="form-group">
                        <label for="password">Password</label>
                        <form:password path="password" cssClass="form-control" id="password"/>
                        <form:errors path="password" cssClass="text-danger small"/>
                    </div>

                    <div class="form-group">
                        <label for="confirmPassword">Confirm Password</label>
                        <form:password path="confirmPassword" cssClass="form-control" id="confirmPassword"/>
                        <form:errors path="confirmPassword" cssClass="text-danger small"/>
                    </div>

                    <div class="text-center">
                        <button type="submit" class="btn btn-primary">Register</button>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</body>
</html>