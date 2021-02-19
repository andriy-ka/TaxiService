<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sing in</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div class="container" align="center">
<h1>Sing in</h1>
<form action="login" method="post">
    <table>
        <tr>
            <td class="h3">Login</td>
            <td>
                <input type="text" name="login">
            </td>
        </tr>
        <tr>
            <td class="h3">Password</td>
            <td>
                <input type="password" name="password">
            </td>
        </tr>
    </table>
    <button type="submit" name="login" value="Login" class="btn btn-lg btn-success">Login</button>
    <button type="submit" name="register" value="Register" class="btn btn-lg btn-primary">Register</button>
</form>
</div>
</body>
</html>
