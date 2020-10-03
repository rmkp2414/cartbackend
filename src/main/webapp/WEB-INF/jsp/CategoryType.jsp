<%--
  Created by IntelliJ IDEA.
  User: Manuja
  Date: 9/10/2020
  Time: 9:26 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="springtag" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <title>Hello, world!</title>
</head>
<body>
<springtag:form method="post" modelAttribute="categoryTypeObj">
    <div class="form-group">
        <br>
        <div class="row">
            &nbsp;&nbsp;&nbsp;&nbsp;<div class="col-2"><label for="">Product Type Name</label></div>
            <div class="col-3"><springtag:input path="productType" type="text" class="form-control" id="p" aria-describedby="productType" placeholder="Enter Product Type"/></div>
        </div>

    </div>
    <div class="form-group">
        <br>
        <div class="row">
            &nbsp;&nbsp;&nbsp;&nbsp;<div class="col-2"><label for="productDescription">Description</label></div>
            <div class="col-3"> <springtag:input path="description" type="text" class="form-control" id="productDescription" placeholder="Enter Product Description"/></div>
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
                <td>Product Type Name</td>
                <td>Description</td>
                <td></td>
                <td></td>
            </tr>
            </thead>

            <tbody>
                <c:forEach items="${catTypeList}" var="categoryType">
                    <tr>
                    <td>${categoryType.id}</td>
                    <td>${categoryType.productType}</td>
                    <td>${categoryType.description}</td>
                    <td><a href="<c:url value='/edit-categorytype-${categoryType.id}'/>" class="btn btn-warning">edit</a></td>
                        <td><a href="<c:url value='/delete-categorytype-${categoryType.id}'/>" class="btn btn-danger">delete</a></td>
                    </tr></c:forEach>

            </tbody>

        </table>

    </div>
</springtag:form>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>



