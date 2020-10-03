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
    <title>Customer</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
<springtag:form method="post" modelAttribute="customerObj">
    <div class="form-group">
        <br>
        <div class="row">
            &nbsp;&nbsp;&nbsp;&nbsp;<div class="col-2"><label for="firstName">First Name</label></div>
            <div class="col-3"><springtag:input path="firstName" type="text" class="form-control" id="p" aria-describedby="productType" placeholder="Enter first Name"/></div>
        </div>

    </div>
    <div class="form-group">
        <br>
        <div class="row">
            &nbsp;&nbsp;&nbsp;&nbsp;<div class="col-2"><label for="lastName">Last Name</label></div>
            <div class="col-3"> <springtag:input path="lastName" type="text" class="form-control" id="productDescription" placeholder="Enter Last Name"/></div>
        </div>

    </div>
    <div class="form-group">
        <br>
        <div class="row">
            &nbsp;&nbsp;&nbsp;&nbsp;<div class="col-2"><label for="email">Email</label></div>
            <div class="col-3"> <springtag:input path="email" type="text" class="form-control" id="productDescription" placeholder="Enter the email"/></div>
        </div>

    </div>

    <div class="form-group">
        <br>
        <div class="row">
            &nbsp;&nbsp;&nbsp;&nbsp;<div class="col-2"><label for="shippingAddress1">Shipping Address Line 1</label></div>
            <div class="col-3"> <springtag:input path="shippingAdressL1" type="text" class="form-control" id="shippingAddress1" placeholder="Enter first line of the address"/></div>
        </div>

    </div>

    <div class="form-group">
        <br>
        <div class="row">
            &nbsp;&nbsp;&nbsp;&nbsp;<div class="col-2"><label for="shippingAddress2">Shipping Address Line 2</label></div>
            <div class="col-3"> <springtag:input path="shippingAdressL2" type="text" class="form-control" id="shippingAddress2" placeholder="Enter second line of the address"/></div>
        </div>

    </div>

    <div class="form-group">
        <br>
        <div class="row">
            &nbsp;&nbsp;&nbsp;&nbsp;<div class="col-2"><label for="zipcode">Zipcode</label></div>
            <div class="col-3"> <springtag:input path="zipCode" type="text" class="form-control" id="productDescription" placeholder="Enter the Zipcode"/></div>
        </div>

    </div>

    <div class="form-group">
        <br>
        <div class="row">
            &nbsp;&nbsp;&nbsp;&nbsp;<div class="col-2"><label for="contactNo">Contact No</label></div>
            <div class="col-3"> <springtag:input path="contactNo" type="text" class="form-control" id="productDescription" placeholder="Enter the Contact Number"/></div>
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
                <td>First Name</td>
                <td>Last Name</td>
                <td>Shipping Address Line1</td>
                <td>Shipping Address Line2</td>
                <td>Zipcode</td>
                <td>Contact No</td>
            </tr>
            </thead>

            <tbody>
            <c:forEach items="${customerList}" var="customerr">
                <tr>
                    <td>${customerr.firstName}</td>
                    <td>${customerr.lastName}</td>
                    <td>${customerr.shippingAdressL1}</td>
                    <td>${customerr.shippingAdressL2}</td>
                    <td>${customerr.zipCode}</td>
                    <td>${customerr.contactNo}</td>
                    <td><a href="<c:url value='/edit-customer-${customerr.id}'/>" class="btn btn-warning">edit</a></td>
                    <td><a href="<c:url value='/delete-customer-${customerr.id}'/>" class="btn btn-danger">delete</a></td>
                </tr></c:forEach>

            </tbody>

        </table>

    </div>
</springtag:form>
</body>
</html>
