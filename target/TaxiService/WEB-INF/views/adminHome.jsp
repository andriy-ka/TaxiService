<%@ page import="andriy.kachur.service.AdminService" %>
<%@ page import="andriy.kachur.model.Order" %>
<%@ page import="andriy.kachur.service.implementation.AdminServiceImpl" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>AdminHome</title>
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
            <p class="navbar-text my-2 my-sm-0 mb-0 h1">Admin ${requestScope.name}, Hello!</p>
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
    <div>
        <p class="h5">Sort by date</p>
        <form action="adminHome" method="get">
            <button class="btn btn-lg btn-success" name="sort" value="Desc">Desc</button>
            <button class="btn btn-lg btn-success" name="sort" value="Asc">Asc</button>
        </form>
    </div>
        <p class="h5">Find by login</p>
        <form action="adminHome" method="get">
            <input type="text" placeholder="Search by login" name="userLogin">
            <button class="btn btn-success" type="submit">Search</button>
        </form>
        <p class="h5">Choose date</p>
        <form action="adminHome" method="get">
            <input type="date" name="date" pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}">
            <button class="btn btn-lg btn-success" type="submit">Search</button>
        </form>
    <div class="container" align="center">
    <table border="1" class="table table-striped table-bordered">
        <thead>
        <tr class="thead-dark">
            <th>Id</th>
            <th>User Name</th>
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
                <td><c:out value='<%= new AdminServiceImpl().getUserById(((Order) pageContext.getAttribute("order")).getUser_id()).getLogin()%>'/></td>
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
    </div>
</div>
</body>
</html>
