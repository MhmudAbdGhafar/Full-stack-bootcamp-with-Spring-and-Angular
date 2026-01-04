package com.ecommerce.app.dao;

import com.ecommerce.app.entity.Product;

import java.util.List;

public interface ProductDAO {

    List<Product> findAll();

    Product findById(int id);

    void save(Product product);

    void update(Product product);

    void delete(int id);

    List<Product> search(String keyword);

}