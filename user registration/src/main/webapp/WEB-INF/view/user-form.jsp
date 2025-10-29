<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>User Registration Form</title>

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
            box-shadow: 0 8px 20px rgba(0, 0, 0, 0.1);
            margin-top: 50px;
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
    <div class="card mx-auto" style="max-width: 600px;">
        <div class="card-header text-center">
            User Registration Form
        </div>

        <div class="card-body">
            <!-- Spring Form -->
            <form:form modelAttribute="user" action="registerUser">

                <!-- User Type -->
                <div class="form-group">
                    <label for="userType">User Type</label>
                    <form:select path="userType" cssClass="form-control" id="userType">
                        <form:option value="">Select Type</form:option>
                        <form:option value="Administrator">Administrator</form:option>
                        <form:option value="Other">Other</form:option>
                    </form:select>
                </div>

                <!-- Username -->
                <div class="form-group">
                    <label for="username">Username</label>
                    <form:input path="username" cssClass="form-control" id="username" placeholder="Enter username"/>
                </div>

                <!-- Password -->
                <div class="form-group">
                    <label for="password">Password</label>
                    <form:password path="password" cssClass="form-control" id="password" placeholder="Enter password"/>
                </div>

                <!-- Country -->
                <div class="form-group">
                    <label for="country">Country</label>
                    <form:select path="country" cssClass="form-control" id="country">
                        <form:option value="">Select Country</form:option>
                        <form:option value="Egypt">Egypt</form:option>
                        <form:option value="USA">USA</form:option>
                        <form:option value="UK">UK</form:option>
                        <form:option value="Germany">Germany</form:option>
                        <form:option value="India">India</form:option>
                        <form:option value="Japan">Japan</form:option>
                    </form:select>
                </div>

                <!-- Preferred Programming Language (Radio) -->
                <div class="form-group">
                    <label>Preferred Programming Language</label><br>
                    <div class="form-check form-check-inline">
                        <form:radiobutton path="preferredLanguage" cssClass="form-check-input" value="Java" id="java"/>
                        <label class="form-check-label" for="java">Java</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <form:radiobutton path="preferredLanguage" cssClass="form-check-input" value="Python" id="python"/>
                        <label class="form-check-label" for="python">Python</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <form:radiobutton path="preferredLanguage" cssClass="form-check-input" value="C++" id="cpp"/>
                        <label class="form-check-label" for="cpp">C++</label>
                    </div>
                </div>

                <!-- Operating System (Checkbox) -->
                <div class="form-group">
                    <label>Operating System</label><br>
                    <div class="form-check">
                        <form:checkbox path="operatingSystems" cssClass="form-check-input" value="Windows" id="windows"/>
                        <label class="form-check-label" for="windows">Windows</label>
                    </div>
                    <div class="form-check">
                        <form:checkbox path="operatingSystems" cssClass="form-check-input" value="Linux" id="linux"/>
                        <label class="form-check-label" for="linux">Linux</label>
                    </div>
                    <div class="form-check">
                        <form:checkbox path="operatingSystems" cssClass="form-check-input" value="macOS" id="macos"/>
                        <label class="form-check-label" for="macos">macOS</label>
                    </div>
                </div>

                <!-- Submit Button -->
                <button type="submit" class="btn btn-primary btn-block mt-3">Register</button>

            </form:form>
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.6.2/js/bootstrap.bundle.min.js"></script>
</body>
</html>
