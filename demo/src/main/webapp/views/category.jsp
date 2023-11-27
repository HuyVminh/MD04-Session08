<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 11/24/2023
  Time: 3:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Danh sách danh mục</h1>
<a href="/danh-muc?action=create">Create Category</a>
<table border="1" cellspacing="0">
    <tr>
        <td>STT</td>
        <td>ID</td>
        <td>Name</td>
        <td>Status</td>
        <td colspan="2">Action</td>
    </tr>
    <c:forEach items='${list}' var="category" varStatus="loop">
        <tr>
            <td>${loop.index+1}</td>
            <td>${category.categoryId}</td>
            <td>${category.categoryName}</td>
            <td>${category.categoryStatus?"Active":"Inactive"}</td>
            <td><a href="/danh-muc?action=edit&id=${category.categoryId}">Edit</a></td>
            <td><a onclick="return confirm('ban co chac chan muon xoa khong?')"
                   href="/danh-muc?action=delete&id=${category.categoryId}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
