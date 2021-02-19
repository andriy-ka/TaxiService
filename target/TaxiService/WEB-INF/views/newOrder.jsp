<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>New Order</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-inverse bg-dark navbar-dark">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="home">Taxi Service</a>
        </div>
        <ul class="navbar navbar-nav navbar-center">
            <p class="navbar-text my-2 my-sm-0 mb-0 h1">${requestScope.name} make your order</p>
        </ul>
        <ul class="navbar navbar-nav navbar-right">
            <li>
                <form action="home" method="post" class="my-2 my-lg-0">
                    <button class="btn btn-success my-2 my-sm-0" type="submit" value="logout" name="logout">Logout</button>
                </form>
            </li>
        </ul>
    </div>
</nav>
<div class="container" align="center">
    <h2>Please fill the fields</h2>
    <form action="home" method="post">
        <table  class="h5" class="table table-striped table-bordered">
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
        <button class="btn btn-lg btn-success" name="submitOrder">Submit</button>
    </form>
</div>
<div align="center" class="h5">
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
<div align="center" class="container">
    <c:choose>
    <c:when test="${requestScope.confirmNewOrder == 0}">
        <div class="h5">Confirm your order</div>
        <table border="1" class="table table-striped table-bordered">
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
                <button class="btn btn-lg btn-success" type="submit" name="confirmNewOrder">Confirm</button>
                <button class="btn btn-lg btn-danger" type="submit" name="denyNewOrder">Deny</button>
            </form>
        </table>
    </c:when>
    </c:choose>
</div>
</body>
</html>