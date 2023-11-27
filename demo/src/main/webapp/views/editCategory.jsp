<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 11/24/2023
  Time: 4:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-lg-6">
            <h1 class="text-center text-danger">Cập nhật danh muc </h1>
            <form action="<%=request.getContextPath()%>/danh-muc?action=edit&id=${category.categoryId}" method="POST">
                <div class="form-group">
                    <label for="categoryId">Id</label>
                    <input type="text" class="form-control" id="categoryId" name="categoryId" value="${category.categoryId}" readonly disabled>
                    <label for="categoryName">Ten danh muc</label>
                    <input type="text" class="form-control" id="categoryName" name="categoryName" value="${category.categoryName}">
                </div>
                <div class="form-group">
                    <label for="Active">Status </label>
                    <input type="radio" id="Active" name="categoryStatus" ${category.categoryStatus?"checked":""} value="true">
                    <label for="Active">Active</label>
                    <input type="radio" id="IsActive" name="categoryStatus" ${!category.categoryStatus?"checked":""} value="false">
                    <label for="IsActive">InActive</label><br>
                </div>

                <button type="submit" class="btn btn-primary">Save</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
