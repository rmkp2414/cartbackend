<%--
  Created by IntelliJ IDEA.
  User: Manuja
  Date: 9/26/2020
  Time: 1:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<jsp:include page="/WEB-INF/jsp/mainHeader.jsp"></jsp:include>
<jsp:include page="/WEB-INF/jsp/mainBody.jsp"></jsp:include>

<form action="/signup" method="POST">
<input name="name">Username</input>
<input name="password" type="password">Passwords</input>
<input name="repassword" type="password">Retype Password </input>
    <button type="submit">Signup</button>
</form>


</body>
</html>
