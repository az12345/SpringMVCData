<%--
  Created by IntelliJ IDEA.
  User: Kharitonov Oleg
  Date: 03.09.2017
  Time: 13:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Emploee</title>
</head>
<body>
<form action="/add" method="post">
    <table>
        <tr>
            <td>name</td>

        </tr>
        <input type="hidden" name="id" value="${emploee.id}">
        <input type="text" name="name" value="${emploee.name}">

        <input type="submit" name="sub" value="SAVE">
    </table>
</form>

</body>
</html>
