<%--
  Created by IntelliJ IDEA.
  User: Manuja
  Date: 9/14/2020
  Time: 11:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="springtag" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Category Sub Type</title>
</head>
<body>
<springtag:form method="post" modelAttribute="categorySubTypeObj">
    <div class="form-group">
        <br>
        <div class="row">
            &nbsp;&nbsp;&nbsp;<div class="col-2"><label for="subTypeName">Category Name</label></div>
            <div class="col-3"> <springtag:select path="categoryTypeObj" items="${categoryList}" itemLabel="productType" itemValue="id" multiple="false">

            </springtag:select> </div>

        </div>

    </div>
    <div class="form-group">
        <br>
        <div class="row">
            &nbsp;&nbsp;&nbsp;&nbsp;<div class="col-2"><label for="subTypeName">Category Sub Type Name</label></div>
            <div class="col-3"> <springtag:input path="subTypeName" type="text" class="form-control" id="subTypeName" placeholder="Enter Category sub type Name"/></div>
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
                <td>Category Type Name</td>

            </tr>
            </thead>

            <tbody>
            <c:forEach items="${categorySubTypeList}" var="categorySubType">
                <tr>
                    <td>${categorySubType.id}</td>
                    <td>${categorySubType.subTypeName}</td>
                    <td><a href="<c:url value='/editcategorysubtype-${categorySubType.id}'/>" class="btn btn-warning">edit</a></td>
                    <td><a href="<c:url value='/deletecategorysubtype-${categorySubType.id}'/>" class="btn btn-danger">delete</a></td>
                </tr></c:forEach>

            </tbody>

        </table>

    </div>
</springtag:form>
</body>
</html>
