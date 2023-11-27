package com.ra.model.dao;

import com.ra.model.entity.Category;
import com.ra.util.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAOImpl implements CategoryDAO {
    @Override
    public List<Category> findAll() {
        Connection connection = null;
        List<Category> categories = new ArrayList<>();
        try {
            connection = ConnectionDB.openConnection();
            PreparedStatement pstm = connection.prepareStatement("SELECT * FROM category");
            ResultSet resultSet = pstm.executeQuery();
            while (resultSet.next()) {
                Category category = new Category();
                category.setCategoryId(resultSet.getInt("id"));
                category.setCategoryName(resultSet.getString("name"));
                category.setCategoryStatus(resultSet.getBoolean("status"));
                categories.add(category);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return categories;
    }

    @Override
    public boolean save(Category category) {
        Connection connection = null;
        if (findById(category.getCategoryId()) == null) {
            try {
                connection = ConnectionDB.openConnection();
                String sql = "INSERT INTO category (name, status) VALUES (?,?)";
                PreparedStatement pstm = connection.prepareStatement(sql);
                pstm.setString(1, category.getCategoryName());
                pstm.setBoolean(2, category.isCategoryStatus());
                int check = pstm.executeUpdate();
                if (check > 0) {
                    return true;
                }
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                ConnectionDB.closeConnection(connection);
            }
        } else {
            try {
                connection = ConnectionDB.openConnection();
                String sql = "UPDATE category SET name = ?,status = ? WHERE id = ?";
                PreparedStatement pstm = connection.prepareStatement(sql);
                pstm.setString(1, category.getCategoryName());
                pstm.setBoolean(2, category.isCategoryStatus());
                pstm.setInt(3, category.getCategoryId());
                int check = pstm.executeUpdate();
                if (check > 0) {
                    return true;
                }
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                ConnectionDB.closeConnection(connection);
            }
        }
        return false;
    }

    @Override
    public Category findById(Integer integer) {
        Connection connection = null;
        Category category = new Category();
        try {
            connection = ConnectionDB.openConnection();
            PreparedStatement pstm = connection.prepareStatement("SELECT * FROM category WHERE id = ?");
            pstm.setInt(1, integer);
            ResultSet resultSet = pstm.executeQuery();
            while (resultSet.next()) {

                category.setCategoryId(resultSet.getInt("id"));
                category.setCategoryName(resultSet.getString("name"));
                category.setCategoryStatus(resultSet.getBoolean("status"));

            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return category;
    }

    @Override
    public void delete(Integer integer) {
        Connection connection = null;
        try {
            connection = ConnectionDB.openConnection();
            PreparedStatement pstm = connection.prepareStatement("DELETE FROM category WHERE id = ?");
            pstm.setInt(1, integer);
            pstm.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(connection);
        }
    }
}
