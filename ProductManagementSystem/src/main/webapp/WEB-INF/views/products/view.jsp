<%@ include file="../layout/header.jsp" %>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/theme.css">

<div class="container mt-4">

    <div class="card">
        <div class="card-header">
            <h4 class="mb-0">Product Details</h4>
        </div>

        <div class="card-body">

            <p><strong>ID:</strong> ${product.id}</p>
            <p><strong>Name:</strong> ${product.name}</p>
            <p><strong>Expiration Date:</strong> ${product.productDetails.expirationDate}</p>
            <p><strong>Manufacturer:</strong> ${product.productDetails.manufacturer}</p>
            <p><strong>Price:</strong> ${product.productDetails.price}</p>
            <p><strong>Available:</strong>
                <c:choose>
                    <c:when test="${product.productDetails.available}">Yes</c:when>
                    <c:otherwise>No</c:otherwise>
                </c:choose>
            </p>

            <a href="${pageContext.request.contextPath}/product/${product.id}" class="btn btn-primary">Edit</a>
            <a href="${pageContext.request.contextPath}/products" class="btn btn-secondary">Back</a>

        </div>
    </div>

</div>