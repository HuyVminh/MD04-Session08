<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 11/24/2023
  Time: 10:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Create customer</h1>
    <a href="customers">Back</a>
    <form method="post">
        <label>Name : </label>
        <input type="text" name="name"><br>
        <label>Email : </label>
        <input type="text" name="email"><br>
        <label>Address : </label>
        <input type="text" name="address"><br>
        <button type="submit">Create</button>
    </form>
</body>
</html>
