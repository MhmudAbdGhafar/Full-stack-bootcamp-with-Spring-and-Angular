package com.ecommerce.app.service;

import com.ecommerce.app.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts();

    void saveProduct(Product product);

    Product getProduct(int id);

    void deleteProduct(int id);
}
