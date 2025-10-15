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
    <body background="${pageContext.request.contextPath}/resources/images/background.jpg">

        <div class="container d-flex justify-content-center align-items-center vh-100">
            <div class="card shadow form-card w-75">
                <div class="card-body">
                    <h3 class="text-center text-primary mb-4">User Registration Form</h3>

                    <form action="register">
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="firstName" class="font-weight-bold">First Name</label>
                                <input type="text" class="form-control" name="firstName"
                                       placeholder="Enter your first name" required>
                            </div>

                            <div class="form-group col-md-6">
                                <label for="lastName" class="font-weight-bold">Last Name</label>
                                <input type="text" class="form-control" name="lastName"
                                       placeholder="Enter your last name" required>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="email" class="font-weight-bold">Email</label>
                            <input type="email" class="form-control" name="email"
                                   placeholder="Enter your email" required>
                        </div>

                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="dateOfBirth" class="font-weight-bold">Date of Birth</label>
                                <input type="date" class="form-control" name="dateOfBirth"  required>
                            </div>

                            <div class="form-group col-md-6">
                                <label for="city" class="font-weight-bold">City</label>
                                <input type="text" class="form-control" name="city"
                                       placeholder="Enter your city" required>
                            </div>
                        </div>

                        <button type="submit" class="btn btn-success btn-block mt-3">Register</button>
                    </form>
                </div>
            </div>
        </div>

    </body>
</html>