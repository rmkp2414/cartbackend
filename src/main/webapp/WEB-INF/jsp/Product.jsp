<%--
  Created by IntelliJ IDEA.
  User: Manuja
  Date: 9/17/2020
  Time: 11:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="springtag" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Product</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
<springtag:form method="post" modelAttribute="productObj">
    <div class="form-group">
        <br>
        <div class="row">
            &nbsp;&nbsp;&nbsp;&nbsp;<div class="col-2"><label for="name">Product  Name</label></div>
            <div class="col-3"><springtag:input path="name" type="text" class="form-control" id="p" aria-describedby="productName" placeholder="Enter Product name"/></div>
        </div>

    </div>
    <div class="form-group">
        <br>
        <div class="row">
            &nbsp;&nbsp;&nbsp;&nbsp;<div class="col-2"><label for="productDescription">Description</label></div>
            <div class="col-3"> <springtag:input path="description" type="text" class="form-control" id="productDescription" placeholder="Enter Product Description"/></div>
        </div>

    </div>
    <div class="row">
        &nbsp;&nbsp;&nbsp;<div class="col-2"><label for="categorySubTypeobj">Category Name</label></div>
        <div class="col-3"> <springtag:select path="categorySubTypeobj" items="${categorySubTypeList}" itemLabel="subTypeName" itemValue="Id" multiple="false">

        </springtag:select> </div>

    </div>
    <div class="form-group form-check">

    </div>
    <br>
    <br>
    <div class="row">
        &nbsp;&nbsp;&nbsp;&nbsp;<c:choose>
        <c:when test="${saveFlag}">
            <input type="submit" value="Save" class="btn btn-primary"/>
        </c:when>
        <c:otherwise>
            &nbsp;<input type="submit" value="Update" class="btn btn-primary"/>
        </c:otherwise>
    </c:choose>
        &nbsp;&nbsp;&nbsp;<button type="button" class="btn btn-secondary">View All</button>
        <div class="col-2">
            <input type="product type id" class="form-control" id="id" placeholder="Enter Product ID">

        </div>
        <div class="col-2">&nbsp;<button type="button" class="btn btn-secondary">Search by Id</button></div>
    </div>

    <br>
    <br>
    <br>
    <div class="row">

        <table class="table table-hover" >
            <thead>
            <tr>
                <td>Id</td>
                <td>Product Name</td>
                <td>Description</td>
                <td>Category</td>
                <td></td>
                <td></td>
            </tr>
            </thead>

            <tbody>
            <c:forEach items="${products}" var="productt">
                <tr>
                    <td>${productt.id}</td>
                    <td>${productt.name}</td>
                    <td>${productt.description}</td>
                    <td>${productt.categorySubTypeobj}</td>
                    <td><a href="<c:url value='/edit-Product-${productt.id}'/>" class="btn btn-warning">edit</a></td>
                    <td><a href="<c:url value='/delete-Product-${productt.id}'/>" class="btn btn-danger">delete</a></td>
                </tr></c:forEach>

            </tbody>

        </table>

    </div>
</springtag:form>
</body>
</html>
