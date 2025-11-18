package com.ecommerce.app.dao;

import com.ecommerce.app.model.Product;

import java.util.List;

public interface ProductDAO {

    List<Product> listProducts();

    void saveProduct(Product product);

    Product findById(int id);

    void deleteProduct(int id);

}