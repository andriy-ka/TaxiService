<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sing up</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
    integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div class="container" align="center">
<h1>Registration</h1>
<form action="registration" method="post">
    <table>
        <tr>
            <td class="h3">Login</td>
            <td>
                <input type="text" name="login" required>
            </td>
        </tr>
        <tr>
            <td class="h3">Email</td>
            <td>
                <input type="text" name="email" required>
            </td>
        </tr>
        <tr>
            <td class="h3">Name</td>
            <td>
                <input type="text" name="name" required>
            </td>
        </tr>
        <tr>
            <td class="h3">Surname</td>
            <td>
                <input type="text" name="surname" required>
            </td>
        </tr>
        <tr>
            <td class="h3">Password</td>
            <td>
                <input type="password" name="password" required>
            </td>
        </tr>
    </table>
    <button type="submit" value="Register" class="btn btn-lg btn-success">Register</button>
</form>
</div>
</body>
</html>
