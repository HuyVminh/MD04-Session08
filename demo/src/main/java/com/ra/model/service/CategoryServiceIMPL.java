package com.ra.model.service;

import com.ra.model.dao.CategoryDAO;
import com.ra.model.dao.CategoryDAOImpl;
import com.ra.model.entity.Category;

import java.util.List;

public class CategoryServiceIMPL implements CategoryService {
    private final CategoryDAO categoryDAO = new CategoryDAOImpl();

    @Override
    public List<Category> findAll() {
        return categoryDAO.findAll();
    }

    @Override
    public boolean save(Category category) {
        return categoryDAO.save(category);
    }

    @Override
    public Category findById(Integer integer) {
        return categoryDAO.findById(integer);
    }

    @Override
    public void delete(Integer integer) {
        categoryDAO.delete(integer);
    }
}
