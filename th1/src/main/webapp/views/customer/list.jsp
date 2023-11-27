<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 11/24/2023
  Time: 9:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        /*table, th, tr, td {*/

        /*    border-collapse: collapse;*/
        /*}*/
        table {
            padding: 8px;
            width: 80%;
            border-collapse: collapse;
        }

        th, td {
            padding: 5px;
            border: 1px solid #ddd;
            text-align: center; /* Căn giữa theo chiều ngang */
        }

        td {
            vertical-align: middle; /* Căn giữa theo chiều dọc */
        }

        a {
            margin: 5px;
            text-decoration: none;
        }
    </style>
</head>
<body>
<a href="customers?action=create">Create customer</a>
<form action="customers">
    <input type="text" name="search" value="${searchName}">
    <input type="submit" value="search" name="action">
</form>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Address</th>
        <th>Email</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${customer}" var="c">
        <tr>
            <td>${c.customerId}</td>
            <td>${c.customerName}</td>
            <td>${c.address}</td>
            <td>${c.email}</td>
            <td>
                <a href="customers?action=edit&id=${c.customerId}">Edit</a>
            </td>
            <td>
                <a onclick="return confirm('Ban co muon xoa ?')"
                   href="customers?action=delete&id=${c.customerId}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
