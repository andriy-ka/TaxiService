<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Welcome Home!</title>
</head>
<body>
<h1>Welcome ${requestScope.name}!</h1>
<table border="1">
    <thead>
    <tr>
        <th>From </th>
        <th>To </th>
        <th>Passengers</th>
        <th>Category</th>
        <th>Date</th>
        <th>Price</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="order" items="${requestScope.orders}">
        <tr>
            <td><c:out value="${order.shippingAddress}"/></td>
            <td><c:out value="${order.destinationAddress}"/></td>
            <td><c:out value="${order.numberOfPassengers}"/></td>
            <td><c:out value="${order.categoryOfCar}"/></td>
            <td><c:out value="${order.date}"/></td>
            <td><c:out value="${order.price}"/></td>
        </tr>
    </c:forEach>
    </tbody>

</table>
<form action="home" method="post">
    <input type="submit" name="logout" value="logout">
    <input type = "submit" name = "newOrder" value="Make Order">
</form>
</body>
</html>
