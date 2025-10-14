<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Enter Birth Date</title>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>
<body>

<div class="container d-flex justify-content-center align-items-center vh-100">
    <div class="card shadow form-card">
        <div class="card-body">
            <h3 class="text-center text-primary mb-4">Age Calculator</h3>

            <form action="calculate" novalidate>
                <div class="form-row">
                    <div class="form-group col-md-4">
                        <label for="year" class="font-weight-bold">Year</label>
                        <input type="number" class="form-control" name="year" placeholder="YYYY" required>
                        <div class="invalid-feedback">Enter a valid year.</div>
                    </div>
                    <div class="form-group col-md-4">
                        <label for="month" class="font-weight-bold">Month</label>
                        <input type="number" class="form-control" name="month" placeholder="MM" required>
                        <div class="invalid-feedback">Enter a valid month (1–12).</div>
                    </div>
                    <div class="form-group col-md-4">
                        <label for="day" class="font-weight-bold">Day</label>
                        <input type="number" class="form-control" name="day" placeholder="DD" required>
                        <div class="invalid-feedback">Enter a valid day (1–31).</div>
                    </div>
                </div>

                <button type="submit" class="btn btn-success btn-block mt-3">Calculate Age</button>
            </form>
        </div>
    </div>
</div>

<!-- Client-side validation -->
<script>
    (function() {
        'use strict';
        $('form').on('submit', function(e) {
            if (this.checkValidity() === false) {
                e.preventDefault();
                e.stopPropagation();
            }
            $(this).addClass('was-validated');
        });
    })();
</script>

</body>