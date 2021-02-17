<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>AdminHome</title>
</head>
<body>
<div align="center">
    <h1>Admin ${requestScope.name}, Hello!</h1>
    <div>Sort by date:
        <form action="adminHome" method="get">
            <input type="submit" name="sort" value="Desc">
            <input type="submit" name="sort" value="Asc">
        </form>
    </div>
    <div>
        <form action="adminHome" method="get">
            <input type="text" name="userLogin">
        </form>
        Choose date:
        <form action="adminHome" method="get">
            <input type="date" name="date" pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}">
            <input type="submit">
        </form>
    </div>
    <table border="1">
        <thead>
        <tr>
            <th>Id</th>
            <th>From</th>
            <th>To</th>
            <th>Passengers</th>
            <th>Category</th>
            <th>Date</th>
            <th>Price</th>
            <th>User Id</th>
            <th>Car Id</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="order" items="${requestScope.orders}">
            <tr>
                <td><c:out value="${order.id}"/></td>
                <td><c:out value="${order.shippingAddress}"/></td>
                <td><c:out value="${order.destinationAddress}"/></td>
                <td><c:out value="${order.numberOfPassengers}"/></td>
                <td><c:out value="${order.categoryOfCar}"/></td>
                <td><c:out value="${order.date}"/></td>
                <td><c:out value="${order.price}"/></td>
                <td><c:out value="${order.user_id}"/></td>
                <td><c:out value="${order.car_id}"/></td>
            </tr>
        </c:forEach>
        </tbody>

    </table>

    <form action="home" method="post">
        <input type="submit" name="logout" value="logout">
    </form>
</div>
</body>
</html>
