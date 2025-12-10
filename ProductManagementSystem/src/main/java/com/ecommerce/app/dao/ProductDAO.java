package com.ecommerce.app.dao;

import com.ecommerce.app.model.Product;

import java.util.List;

public interface ProductDAO {

    List<Product> listProducts();

    void saveProduct(Product product);

    void updateProduct(Product product);

    Product findById(int id);

    void deleteProduct(int id);

    List<Product> searchProductsByName(String keyword);

}