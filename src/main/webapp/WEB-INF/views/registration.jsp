<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sing up</title>
</head>
<body>
<h1>Registration</h1>
<form action="registration" method="post">
    <table>
        <tr>
            <td>Login</td>
            <td>
                <input type="text" name="login" required>
            </td>
        </tr>
        <tr>
            <td>Email</td>
            <td>
                <input type="text" name="email" required>
            </td>
        </tr>
        <tr>
            <td>Name</td>
            <td>
                <input type="text" name="name" required>
            </td>
        </tr>
        <tr>
            <td>Surname</td>
            <td>
                <input type="text" name="surname" required>
            </td>
        </tr>
        <tr>
            <td>Password</td>
            <td>
                <input type="password" name="password" required>
            </td>
        </tr>
    </table>
    <input type="submit" value="Register">
</form>
</body>
</html>
