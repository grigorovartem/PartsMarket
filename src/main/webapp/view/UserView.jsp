<%--
  Created by IntelliJ IDEA.
  User: Артем
  Date: 08.02.17
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.servletContext.contextPath}/filter" method="post">
    <table>
        <tr>
            <td align="right">Price from :</td>
            <td>
                <input type="text" name="priceFrom">
            </td>
        </tr>
        <tr>
            <td align="right">Price to :</td>
            <td>
                <input type="text" name="priceTo">
            </td>
        </tr>
        <tr>
            <td><input type="submit" align="center" value="Submit"/></td>
        </tr>
    </table>
</form>
<form action="${pageContext.servletContext.contextPath}/" method="get">
    <table border="1">
        <tr>
            <td>Наименование</td>
            <td>Цена</td>
            <td>Бренд</td>
            <td>Количество</td>
        </tr>
        <c:forEach items="${storage}" var="storage" varStatus="status">
            <tr valign="top">
                <td>${storage.key.name}</td>
                <td>${storage.key.price}</td>
                <td>${storage.key.brand}</td>
                <td>${storage.value}</td>
            </tr>
        </c:forEach>
    </table>
</form>

</body>
</html>
