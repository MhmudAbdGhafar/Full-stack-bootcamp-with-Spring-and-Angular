<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <title>View Product</title>

    <%--import Bootstrap--%>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">

</head>

<body>

<jsp:include page="navbar.jsp"/>

<div class="container mt-5">

    <div class="card p-4 shadow-lg">

        <h3 class="mb-3">${product.name}</h3>

        <p><strong>ID:</strong> ${product.id}</p>
        <p><strong>Name:</strong> ${product.productDetails.name}</p>
        <p><strong>Expiration Date:</strong> ${product.productDetails.expirationDate}</p>
        <p><strong>Manufacturer:</strong> ${product.productDetails.manufacturer}</p>
        <p><strong>Price:</strong> ${product.productDetails.price}</p>
        <p><strong>Available:</strong>
            <c:choose>
                <c:when test="${product.productDetails.available}">Yes</c:when>
                <c:otherwise>No</c:otherwise>
            </c:choose>
        </p>

        <a href="${pageContext.request.contextPath}/products/list"
           class="btn btn-secondary mt-3">Back</a>

    </div>

</div>

</body>
</html>