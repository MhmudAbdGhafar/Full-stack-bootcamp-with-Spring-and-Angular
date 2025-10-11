<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Result</title>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css"/>

</head>
<body>

<div class="container d-flex justify-content-center align-items-center vh-100">
    <div class="card shadow result-card text-center">
        <div class="card-body">
            <h3 class="text-primary mb-4">Age Difference Result</h3>

            <!-- Error message -->
            <h3>${error}</h3>

            <!-- Result message -->
            <h3>${result}</h3>

            <a href="${pageContext.request.contextPath}/" class="btn btn-outline-primary btn-block mt-3">← Back to Input Page</a>
        </div>
    </div>
</div>

</body>