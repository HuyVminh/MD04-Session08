package com.example.th1.service;

import com.example.th1.model.Customer;

import java.util.List;

public interface IGenericService<T> {
    List<T> findAll();
    void save(T t);
    void deleteById(int id);
    T findById(int id);
    int getNewId();
    List<T> findByName(String name);
}
