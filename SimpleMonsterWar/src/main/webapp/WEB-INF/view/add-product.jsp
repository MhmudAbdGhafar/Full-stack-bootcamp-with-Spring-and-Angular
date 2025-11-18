<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
    <title>Add Product</title>

    <%--import Bootstrap--%>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">

</head>

<body>

<jsp:include page="navbar.jsp"/>

<div class="container mt-5">

    <div class="card p-4 shadow-lg">

        <h3 class="text-center mb-4">Add Product</h3>

        <form:form action="${pageContext.request.contextPath}/products/save" method="post" modelAttribute="product">

            <div class="form-group">
                <label>Product Name</label>
                <form:input path="name" cssClass="form-control"/>
            </div>

            <h5 class="mt-4">Product Details</h5>

            <form:form action="save" method="post" modelAttribute="details">

                <div class="form-group">
                    <label>Name</label>
                    <form:input path="name" cssClass="form-control"/>
                    <form:errors path="name" cssClass="text-danger"/>
                </div>

                <div class="form-group">
                    <label>Expiration Date</label>
                    <form:input type="date" path="expirationDate"
                                cssClass="form-control"/>
                    <form:errors path="expirationDate" cssClass="text-danger"/>
                </div>

                <div class="form-group">
                    <label>Manufacturer</label>
                    <form:input path="manufacturer" cssClass="form-control"/>
                    <form:errors path="manufacturer" cssClass="text-danger"/>
                </div>

                <div class="form-group">
                    <label>Price</label>
                    <form:input type="number" step="0.01" path="price" cssClass="form-control"/>
                    <form:errors path="price" cssClass="text-danger"/>
                </div>

                <div class="form-group">
                    <label>Available</label>
                    <form:checkbox path="available"/>
                </div>

            </form:form>

            <button class="btn btn-success btn-block mt-3">Save</button>

        </form:form>

    </div>

</div>

</body>
</html>