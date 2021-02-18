<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>New Order</title>
</head>
<body>
<div align="center">
    <h1>Make your order</h1>
    <form action="home" method="post">
        <table>
            <tr>
                <td>From</td>
                <td>
                    <select name="shippingAddress" id="shippingAddress">
                        <c:forEach var="city" items="${requestScope.cities}">
                            <option value="${city.name}">${city.name}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>To</td>
                <td>
                    <select name="destinationAddress" id="destinationAddress">
                        <c:forEach var="city" items="${requestScope.cities}">
                            <option value="${city.name}">${city.name}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Passengers</td>
                <td>
                    <input type="number" name="passengers" required>
                </td>
            </tr>
            <tr>
                <td>Category</td>
                <td>
                    <input type="radio" id="categoryChoice1"
                           name="category" value="Business">
                    <label for="categoryChoice1">Business</label>

                    <input type="radio" id="categoryChoice2"
                           name="category" value="Economy">
                    <label for="categoryChoice2">Economy</label>
                </td>
            </tr>
        </table>
        <input type="submit" name="submitOrder" value="Submit">
    </form>
</div>
<div align="center">
    <c:choose>
        <c:when test="${requestScope.numberOfCarByPlaces == 0}">
            <div style="color: red">Sorry, but now we dont have car with this number of places, now.</div>
            <div style="color: darkslateblue">But you can make multiple orders, dividing places.</div>
        </c:when>
        <c:when test="${requestScope.numberOfCarByCategory == 0}">
            <div style="color: red">Sorry, but now we dont have car with this category, now.</div>
            <div style="color: darkslateblue">But you can make order with another category.</div>
        </c:when>
        <c:when test="${requestScope.car_id == 0}">
            <div style="color: red">Sorry, but now we dont have car for this order, now.</div>
            <div style="color: darkslateblue">Make your order later</div>
        </c:when>
    </c:choose>
</div>
<div align="center">
    <c:choose>
    <c:when test="${requestScope.confirmNewOrder == 0}">
        <div style="color: green">Confirm your order</div>
        <table border="1">
            <thead>
            <tr>
                <th>From</th>
                <th>To</th>
                <th>Passengers</th>
                <th>Category</th>
                <th>Date</th>
                <th>Price</th>
            </tr>
            </thead>
            <tbody>
            <c:set var="order" value="${requestScope.order}"/>
            <tr>
                <td><c:out value="${order.shippingAddress}"/></td>
                <td><c:out value="${order.destinationAddress}"/></td>
                <td><c:out value="${order.numberOfPassengers}"/></td>
                <td><c:out value="${order.categoryOfCar}"/></td>
                <td><c:out value="${order.date}"/></td>
                <td><c:out value="${order.price}"/></td>
            </tr>
            </tbody>
            <form action="home" method="post">
                <input type="submit" name="confirmNewOrder" value="Confirm">
                <input type="submit" name="denyNewOrder" value="Deny">
            </form>
        </table>
    </c:when>
    </c:choose>
</div>

</body>
</html>