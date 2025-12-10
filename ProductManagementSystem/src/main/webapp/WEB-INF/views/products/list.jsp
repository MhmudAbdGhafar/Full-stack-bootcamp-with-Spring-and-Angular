<%@ include file="../layout/header.jsp" %>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/theme.css">

<div class="container mt-4">

    <div class="card">
        <div class="card-header d-flex justify-content-between align-items-center">
            <h4 class="mb-0">Product List</h4>

            <!-- Toolbar -->
            <div class="d-flex">
                <!-- Search -->
                <form action="${pageContext.request.contextPath}/search" method="get" class="d-flex me-2">
                    <input type="text"
                           name="keyword"
                           value="${keyword != null ? keyword : ''}"
                           class="form-control"
                           placeholder="Search product..."/>
                    <button type="submit" class="btn btn-primary ms-2">Search</button>
                </form>

                <!-- Add Button -->
                <a href="${pageContext.request.contextPath}/product" class="btn btn-primary ms-2">Add Product</a>
            </div>
        </div>

        <div class="card-body">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th style="width: 250px;">Actions</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="p" items="${products}">
                    <tr>
                        <td>${p.id}</td>
                        <td>${p.name}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/view/${p.id}" class="btn-primary btn-sm">View</a>
                            <a href="${pageContext.request.contextPath}/product/${p.id}" class="btn-edit btn-sm">Edit</a>
                            <a href="${pageContext.request.contextPath}/delete/${p.id}" class="btn-delete btn-sm"
                               onclick="return confirm('Are you sure?')">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

</div>