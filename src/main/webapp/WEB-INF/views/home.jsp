<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Welcome Home!</title>
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
                <p class="navbar-text my-2 my-sm-0 mb-0 h1">Welcome ${requestScope.name}!</p>
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
    <h2>Your orders</h2>
    <table border="1" class="table table-striped table-bordered" >
        <thead>
        <tr class="thead-dark">
            <th>From</th>
            <th>To</th>
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
    <form action="home" method="post" class="container">
        <input type="submit" name="newOrder" value="Make Order" class="btn btn-success btn-lg">
    </form>
</div>
</body>
</html>
