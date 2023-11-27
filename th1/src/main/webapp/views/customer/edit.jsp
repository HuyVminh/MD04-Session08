<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 11/24/2023
  Time: 10:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Edit customer</h1>
<a href="customers">Back</a>
<form method="post">
    <label>Id : </label>
    <input type="number" name="id" value="${customer.customerId}" disabled readonly><br>
    <label>Name : </label>
    <input type="text" name="name" value="${customer.customerName}"><br>
    <label>Email : </label>
    <input type="text" name="email" value="${customer.email}"><br>
    <label>Address : </label>
    <input type="text" name="address" value="${customer.address}"><br>
    <button type="submit">Save</button>
</form>
</body>
</html>
