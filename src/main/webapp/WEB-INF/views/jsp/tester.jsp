<%--
  Created by IntelliJ IDEA.
  User: Angelica Yunshu Li
  Date: 7/29/2016
  Time: 10:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Huge Title</title>
</head>
<body>
    <form action="/test" method="post">
        UserID: <input name="userid" type="number"/>
        Name: <input name="name" type="text"/>
        <input type="submit"/>
    </form>
    <br>----------------------------------------<br>
    All Users:<br>
    ${users}
</body>
</html>
