<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>User Registration</title>

    <!-- Bootstrap 4 -->
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">

    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/css/style.css">

</head>
    <body>

        <div class="container d-flex justify-content-center align-items-center vh-100">
            <div class="card shadow result-card text-center">
                <div class="card-body">
                    <h3 class="text-primary mb-4">User Data</h3>

                    <h3>First Name "${firstName}"</h3>
                    <h3>Last Name "${lastName}"</h3>
                    <h3>Email "${email}"</h3>
                    <h3>Date Of Birth "${dateOfBirth}"</h3>
                    <h3>city "${city}"</h3>

                    <a href="${pageContext.request.contextPath}/" class="btn btn-outline-primary btn-block mt-3">← Back to Input Page</a>
                </div>
            </div>
        </div>

    </body>
</html>