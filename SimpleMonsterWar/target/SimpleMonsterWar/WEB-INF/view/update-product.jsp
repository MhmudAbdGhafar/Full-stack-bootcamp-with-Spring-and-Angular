<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
    <title>Update Product</title>

    <%--import Bootstrap--%>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">

</head>

<body>

<jsp:include page="navbar.jsp"/>

<div class="container mt-5">

    <div class="card p-4 shadow-lg">

        <h3 class="text-center mb-4">Update Product</h3>

        <form:form action="${pageContext.request.contextPath}/products/update"
                   method="post" modelAttribute="product">

            <form:hidden path="id"/>

            <div class="form-group">
                <label>Product Name</label>
                <form:input path="name" cssClass="form-control"/>
            </div>

            <h5 class="mt-4">Product Details</h5>

            <form:form modelAttribute="details">

                <form:hidden path="id"/>

                <div class="form-group">
                    <label>Name</label>
                    <form:input path="name" cssClass="form-control"/>
                </div>

                <div class="form-group">
                    <label>Expiration Date</label>
                    <form:input type="date" path="expirationDate"
                                cssClass="form-control"/>
                </div>

                <div class="form-group">
                    <label>Manufacturer</label>
                    <form:input path="manufacturer" cssClass="form-control"/>
                </div>

                <div class="form-group">
                    <label>Price</label>
                    <form:input type="number" step="0.01" path="price" cssClass="form-control"/>
                </div>

                <div class="form-group">
                    <label>Available</label>
                    <form:checkbox path="available"/>
                </div>

            </form:form>

            <button class="btn btn-primary btn-block mt-3">Update</button>

        </form:form>

    </div>

</div>

</body>
</html>