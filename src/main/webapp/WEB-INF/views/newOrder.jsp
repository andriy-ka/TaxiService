<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                <td>Shipping address</td>
                <td>
                    <input type="text" name="shippingAddress" required>
                </td>
            </tr>
            <tr>
                <td>Destination address</td>
                <td>
                    <input type="text" name="destinationAddress" required>
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
</body>
</html>
