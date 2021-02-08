<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sing in</title>
</head>
<body>
<h1>Sing in</h1>
<form action="login" method="post">
    <table>
        <tr>
            <td>Login</td>
            <td>
                <input type="text" name="login" required>
            </td>
        </tr>
        <tr>
            <td>Password</td>
            <td>
                <input type="password" name="password" required>
            </td>
        </tr>
    </table>
    <input type="submit" value="Login">
</form>
</body>
</html>
