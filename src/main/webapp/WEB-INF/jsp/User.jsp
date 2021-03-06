<%--
  Created by IntelliJ IDEA.
  User: Manuja
  Date: 9/17/2020
  Time: 4:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="springtag" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
<springtag:form method="post" modelAttribute="userObj">
    <div class="form-group">
        <br>
        <div class="row">
            &nbsp;&nbsp;&nbsp;&nbsp;<div class="col-2"><label for="username">User Name</label></div>
            <div class="col-3"><springtag:input path="username" type="text" class="form-control" id="id" aria-describedby="username" placeholder="Enter User Name"/></div>
        </div>

        <div class="row">
            &nbsp;&nbsp;&nbsp;<div class="col-2"><label for="userType">User Type</label></div>
            <div class="col-3"> <springtag:select path="userType" items="${userTypeList}" itemLabel="userType" itemValue="id" multiple="false">

            </springtag:select> </div>

        </div>

        <div class="row">
            &nbsp;&nbsp;&nbsp;&nbsp;<div class="col-2"><label for="password">Password</label></div>
            <div class="col-3"><springtag:input path="password" type="password" class="form-control" id="id"  placeholder="Enter Password"/></div>
        </div>
        <div class="row">
            &nbsp;&nbsp;&nbsp;&nbsp;<div class="col-2"><label for="confirmPassword">Confirm Password</label></div>
            <div class="col-3"><springtag:input path="confirmPassword" type="password" class="form-control" id="id"  placeholder="Enter confirm password"/></div>
        </div>
        <div class="form-group form-check">

        </div>
    </div>


    <br>
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
            <input type="user type name" class="form-control" id="id" placeholder="Enter User Type ">

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
                <td>User Name</td>
                <td>User Type</td>
                <td>Password</td>
                <td>Confirm Password</td>
            </tr>
            </thead>

            <tbody>
            <c:forEach items="${userList}" var="userr">
                <tr>
                    <td>${userr.id}</td>
                    <td>${userr.username}</td>
                    <td>${userr.userType}</td>
                    <td>${userr.password}</td>
                    <td>${userr.confirmPassword}</td>
                    <td><a href="<c:url value='/edit-user-${userr.id}'/>" class="btn btn-warning">edit</a></td>
                    <td><a href="<c:url value='/delete-user-${userr.id}'/>" class="btn btn-danger">delete</a></td>
                </tr></c:forEach>

            </tbody>

        </table>

    </div>
</springtag:form>
</body>
</html>
