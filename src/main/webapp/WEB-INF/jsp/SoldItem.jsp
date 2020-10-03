<%--
  Created by IntelliJ IDEA.
  User: Manuja
  Date: 9/18/2020
  Time: 9:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="springtag" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Sold Item</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>

<body>
<springtag:form method="post" modelAttribute="soldItemObj">
    <div class="form-group">
    <br>


    </div>
    <div class="form-group">
    <br>
    <div class="row">
    &nbsp;&nbsp;&nbsp;&nbsp;<div class="col-2"><label for="productItemId">Product Item Id</label></div>
    <div class="col-3"> <springtag:input path="productItemId" type="text" class="form-control" id="id" placeholder="Product Item ID"/></div>
    </div>

    <div class="row">
    &nbsp;&nbsp;&nbsp;&nbsp;<div class="col-2"><label for="quantity">Quantity</label></div>
    <div class="col-3"> <springtag:input path="quantity" type="text" class="form-control" id="id" placeholder="Quantity"/></div>
    </div>

    <div class="row">
    &nbsp;&nbsp;&nbsp;&nbsp;<div class="col-2"><label for="completedOrderObj">Completed Order</label></div>
    <div class="col-3"> <springtag:input path="completedOrderObj" type="text" class="form-control" id="id" placeholder="Completed Order"/></div>
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
    <td>ID</td>
    <td>Product Item ID</td>
    <td>Quantity</td>
    <td>Completed Order No</td>

    </tr>
    </thead>

    <tbody>
    <c:forEach items="${soldItems}" var="SoldItems">
        <tr>
            <td>${SoldItems.id}</td>
            <td>${SoldItems.productItemId}</td>
            <td>${SoldItems.quantity}</td>
            <td>${SoldItems.completedOrderObj}</td>
            <td></td>
            <td></td>

            <td><a href="<c:url value='/edit-solditem-${SoldItems.id}'/>" class="btn btn-warning">edit</a></td>
            <td><a href="<c:url value='/delete-solditem-${SoldItems.id}'/>" class="btn btn-danger">delete</a></td>
        </tr></c:forEach>
    </tbody>>
    </table>
    </div>
</springtag:form>
    </body>
</body>
</html>
