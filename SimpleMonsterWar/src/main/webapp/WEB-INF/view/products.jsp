<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
<head>
    <title>Products</title>

    <%--import Bootstrap--%>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">

</head>

<body style="background: linear-gradient(120deg, #e3f2fd, #ffffff);">

<jsp:include page="navbar.jsp"/>

<div class="container mt-5">

    <h3 class="text-center mb-4">Product List</h3>

    <div class="card shadow-lg p-4">

        <table class="table table-striped table-bordered">
            <thead class="thead-dark">
            <tr>
                <th>ID</th>
                <th>Product</th>
                <th>View</th>
                <th>Update</th>
                <th>Delete</th>
            </tr>
            </thead>

            <tbody>
            <c:forEach var="p" items="${products}">
                <tr>
                    <td>${p.id}</td>
                    <td>${p.name}</td>

                    <td>
                        <a class="btn btn-info btn-sm"
                           href="${pageContext.request.contextPath}/products/view/${p.id}">
                            View
                        </a>
                    </td>

                    <td>
                        <a class="btn btn-warning btn-sm"
                           href="${pageContext.request.contextPath}/products/update/${p.id}">
                            Update
                        </a>
                    </td>

                    <td>
                        <a class="btn btn-danger btn-sm"
                           href="${pageContext.request.contextPath}/products/delete/${p.id}"
                           onclick="return confirm('Are you sure?')">
                            Delete
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>

        </table>

    </div>

</div>

</body>
</html>