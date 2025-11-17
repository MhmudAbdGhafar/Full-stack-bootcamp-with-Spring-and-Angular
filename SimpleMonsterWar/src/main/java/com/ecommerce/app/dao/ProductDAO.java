package com.ecommerce.app.dao;

import com.ecommerce.app.model.Product;

import java.util.List;

public interface ProductDAO {

    Product insert(Product product);

    Product findById(int id);

    Product deleteById(int id);

    Product update(Product product);

    List<Product> findAll();

}