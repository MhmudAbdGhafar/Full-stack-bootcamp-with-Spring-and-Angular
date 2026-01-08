package com.ecommerce.app.dao;

import com.ecommerce.app.entity.Product;

import java.util.List;

public interface ProductDAO {

    List<Product> findAll();

    Product findById(int id);

    Product save(Product product);

    Product update(Product product);

    Product delete(int id);
}