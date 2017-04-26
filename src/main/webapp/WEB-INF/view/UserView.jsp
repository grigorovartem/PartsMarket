
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" pageEncoding="UTF-8" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="navbar-header">
<form action="${pageContext.servletContext.contextPath}/userView/filter/search" method="post">
    <input type="text" size="20" class="form-control" name="pattern" placeholder="Search">
    <input type="submit" class="btn btn-default" value="Search">
</form>
    </div>
<form action="${pageContext.servletContext.contextPath}/userView/filter/price" method="post">
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
<form action="${pageContext.servletContext.contextPath}/userView/addPart" method="post">
    <table>
        <tr>
            <td align="right">Name :</td>
            <td>
                <input type="text" name="name">
            </td>
        </tr>
        <tr>
            <td align="right">Price :</td>
            <td>
                <input type="text" name="price">
            </td>
        </tr>
        <tr>
            <td align="right">Brand :</td>
            <td>
                <input type="text" name="brand">
            </td>
        </tr>
        <tr>
            <td align="right">Quality :</td>
            <td>
                <input type="text" name="quality">
            </td>
        </tr>
        <tr>
            <td><input type="submit" align="center" value="Submit"/></td>
        </tr>
    </table>
</form>
<form action="${pageContext.servletContext.contextPath}/sort" method="post">
    <p><select name="condition">
        <option disabled>Sort results</option>
        <option selected value="name">By name</option>
        <option value="ascending">Ascending price</option>
        <option value="decreasing">Decreasing price</option>
    </select></p>
    <p><input type="submit" value="Sort"></p>
</form>
<spring:form action="${pageContext.servletContext.contextPath}/userView" method="get">
    <table border="1">
        <tr>
            <td>Наименование</td>
            <td>Цена</td>
            <td>Бренд</td>
            <td>Количество</td>
            <td>Добавить</td>
        </tr>
        <c:forEach items="${storage}" var="storage" varStatus="status">
            <tr valign="top">
                <td>${storage.part.name}</td>
                <td>${storage.part.price}</td>
                <td>${storage.part.brand}</td>
                <td>${storage.quantity}</td>
                <td><a href="${pageContext.servletContext.contextPath}/userView/add?part=${storage.part.id}">Add</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</spring:form>
<form action="${pageContext.servletContext.contextPath}/userView/newOrder" method="get">
    <input type="submit" align="center" value="New Order"/>
</form>
<spring:form action="${pageContext.servletContext.contextPath}/userView" method="get">
    <table border="1">
        <tr>
            <td>Наименование</td>
            <td>Цена</td>
            <td>Бренд</td>
            <td>Количество</td>
            <td>Добавить</td>
        </tr>
        <c:forEach items="${parts}" var="partItem" varStatus="status">
            <tr valign="top">
                <td>${partItem.part.name}</td>
                <td>${partItem.part.price}</td>
                <td>${partItem.part.brand}</td>
                <td>${partItem.quantity}</td>
                <td><a href="${pageContext.servletContext.contextPath}/userView/delete">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</spring:form>
<a href="${pageContext.servletContext.contextPath}/logout">Log out</a>

</body>
</html>
