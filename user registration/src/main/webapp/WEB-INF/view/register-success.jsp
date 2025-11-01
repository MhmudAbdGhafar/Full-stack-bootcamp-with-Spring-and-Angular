<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Registration Successful</title>

    <!-- Bootstrap 4 -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">

    <style>
        body {
            background: linear-gradient(120deg, #e3f2fd, #ffffff);
            font-family: 'Poppins', sans-serif;
        }
        .card {
            border-radius: 15px;
            box-shadow: 0 10px 25px rgba(0, 0, 0, 0.1);
            margin-top: 60px;
        }
        .card-header {
            background-color: #28a745;
            color: white;
            font-weight: 600;
            border-top-left-radius: 15px;
            border-top-right-radius: 15px;
        }
        .icon-check {
            font-size: 50px;
            color: #28a745;
        }
        .table th {
            background-color: #f8f9fa;
            width: 40%;
            font-weight: 600;
        }
        .btn-primary {
            border-radius: 8px;
            font-weight: 600;
        }
    </style>
</head>

<body>
<div class="container d-flex justify-content-center align-items-center vh-100">
    <div class="card text-center w-100" style="max-width: 700px;">
        <div class="card-header">
            Registration Successful 🎉
        </div>

        <div class="card-body">
            <div class="icon-check mb-3">✅</div>
            <p class="lead text-muted mb-4">The user information has been successfully saved.</p>

            <table class="table table-bordered text-left">
                <tbody>
                <tr>
                    <th>User Type</th>
                    <td>${user.userType}</td>
                </tr>
                <tr>
                    <th>Username</th>
                    <td>${user.username}</td>
                </tr>
                <tr>
                    <th>Password</th>
                    <td>********</td>
                </tr>
                <tr>
                    <th>Country</th>
                    <td>${user.country}</td>
                </tr>
                <tr>
                    <th>Preferred Programming Language</th>
                    <td>${user.preferredLanguage}</td>
                </tr>
                <tr>
                    <th>Operating Systems</th>
                    <td>
                        <ul class="mb-0">
                            <c:forEach var="os" items="${user.operatingSystems}">
                                <li>${os}</li>
                            </c:forEach>
                        </ul>
                    </td>
                </tr>
                </tbody>
            </table>

            <a href="${pageContext.request.contextPath}/" class="btn btn-primary btn-block mt-3">← Register Another User</a>
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.6.2/js/bootstrap.bundle.min.js"></script>
</body>
</html>
