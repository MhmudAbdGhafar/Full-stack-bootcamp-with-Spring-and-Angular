<%@ include file="../layout/header.jsp" %>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/theme.css">

<div class="container mt-4">

    <div class="card">
        <div class="card-header">
            <h4 class="mb-0">Edit Product</h4>
        </div>

        <div class="card-body">
            <form:form method="post" modelAttribute="product" action="${pageContext.request.contextPath}/update">

                <form:hidden path="id"/>

                <div class="mb-3">
                    <label class="form-label">Name</label>
                    <form:input path="name" cssClass="form-control"/>
                    <form:errors path="name" cssClass="field-error"/>
                </div>

                <div class="mb-3">
                    <label class="form-label">Expiration Date</label>
                    <form:input path="productDetails.expirationDate" type="date" cssClass="form-control"/>
                    <form:errors path="productDetails.expirationDate" cssClass="field-error"/>
                </div>

                <div class="mb-3">
                    <label class="form-label">Manufacturer</label>
                    <form:input path="productDetails.manufacturer" cssClass="form-control" placeholder="Enter manufacturer name"/>
                    <form:errors path="productDetails.manufacturer" cssClass="field-error"/>
                </div>

                <div class="mb-3">
                    <label class="form-label">Price</label>
                    <form:input path="productDetails.price" type="number" step="0.01" cssClass="form-control" placeholder="Enter price"/>
                    <form:errors path="productDetails.price" cssClass="field-error"/>
                </div>

                <div class="mb-3">
                    <label class="form-label">Available</label>
                    <form:checkbox path="productDetails.available"/>
                    <form:errors path="productDetails.available" cssClass="field-error"/>
                </div>

                <button class="btn btn-primary">Update</button>
                <a href="${pageContext.request.contextPath}/products" class="btn btn-secondary">Back</a>

            </form:form>
        </div>
    </div>

</div>