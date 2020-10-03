<%--
  Created by IntelliJ IDEA.
  User: Manuja
  Date: 9/18/2020
  Time: 8:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="springtag" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Product Item Picture</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
<springtag:form method="post" modelAttribute="ProductItemPicObj">
<div class="form-group">
    <br>
    <div class="row">
        &nbsp;&nbsp;&nbsp;<div class="col-2"><label for="productItem">Product Item</label></div>
        <div class="col-3"> <springtag:select path="productItemObj" items="${productItemList}" itemLabel="productItem" itemValue="id" multiple="false">

        </springtag:select> </div>

    </div>
    <div class="row">
        &nbsp;&nbsp;&nbsp;&nbsp;<div class="col-2"><label for="path">Path</label></div>
        <div class="col-3"><springtag:input path="path" type="text" class="form-control" id="p" aria-describedby="productPath" placeholder="Enter Product path"/></div>
    </div>

</div>
<div class="form-group">
    <br>
    <div class="row">
        &nbsp;&nbsp;&nbsp;&nbsp;<div class="col-2"><label for="picture">Picture</label></div>
        <div class="col-3"> <springtag:input path="picture" type="text" class="form-control" id="productPicture" placeholder="Enter Product picture"/></div>
    </div>

</div>

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
                <td>Product Item ID</td>
                <td>Path</td>
                <td>Picture</td>
                <td></td>
                <td></td>
            </tr>
            </thead>

            <tbody>
            <c:forEach items="${productItemPIctureList}" var="productPicture">
                <tr>
                    <td>${productPicture.id}</td>
                    <td>${productPicture.productItemObj}</td>
                    <td>${productPicture.path}</td>
                    <td>${productPicture.picture}</td>

                    <td><a href="<c:url value='/edit-productitempicture-${productPicture.id}'/>" class="btn btn-warning">edit</a></td>
                    <td><a href="<c:url value='/delete-productitempicture-${productPicture.id}'/>" class="btn btn-danger">delete</a></td>
                </tr></c:forEach>

            </tbody>

        </table>

    </div>
    </springtag:form>
</body>
</html>
