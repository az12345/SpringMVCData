<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Сизиф
  Date: 31.08.2017
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
<form method="post" action="/add">
  <input type="text" name="name">
  <input type="submit" name="ADD">
</form>
  <table>
    <tr>
      <td>id</td>
      <td>name</td>
    </tr>
    <c:forEach items="${list}" var="emploee">
    <tr>
      <td>${emploee.id}</td>
      <td>${emploee.name}</td>
    </tr>
    </c:forEach>
  </table>
  </body>
</html>
