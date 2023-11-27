package com.ra.controller;

import com.ra.model.entity.Category;
import com.ra.model.service.CategoryService;
import com.ra.model.service.CategoryServiceIMPL;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CategoryController", value = "/danh-muc")
public class CategoryController extends HttpServlet {
    private CategoryService categoryService = new CategoryServiceIMPL();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            showCategory(request, response);
        }
        switch (action) {
            case "create":
                response.sendRedirect("views/createCategory.jsp");
                break;
            case "edit":
                int categoryId = Integer.parseInt(request.getParameter("id"));
                Category category = categoryService.findById(categoryId);
                request.setAttribute("category", category);
                request.getRequestDispatcher("views/editCategory.jsp").forward(request, response);
                break;
            case "delete":
                int categoryIdDelete = Integer.parseInt(request.getParameter("id"));
                categoryService.delete(categoryIdDelete);
                showCategory(request, response);
                break;
            default:
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        System.out.println(action);
        if (action == null) {
            // lấy dữ liệu
            Category category = new Category();
            category.setCategoryName(request.getParameter("categoryName".trim()));
            category.setCategoryStatus(Boolean.parseBoolean(request.getParameter("categoryStatus")));
            if (categoryService.save(category)) {
                showCategory(request, response);
            }
            response.sendRedirect("views/createCategory.jsp?err");
        } else {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("categoryName");
            Boolean status = Boolean.parseBoolean(request.getParameter("categoryStatus"));
            Category categoryEdit = categoryService.findById(id);
            categoryEdit.setCategoryName(name);
            categoryEdit.setCategoryStatus(status);
            if (categoryService.save(categoryEdit)) {
                showCategory(request, response);
            }
            response.sendRedirect("views/editCategory.jsp?err");
        }
    }

    public void showCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> list = categoryService.findAll();
        request.setAttribute("list", list);
        request.getRequestDispatcher("views/category.jsp").forward(request, response);
    }
}