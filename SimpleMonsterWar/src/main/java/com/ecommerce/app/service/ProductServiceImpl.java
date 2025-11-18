package com.ecommerce.app.service;

import com.ecommerce.app.dao.ProductDAO;
import com.ecommerce.app.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private ProductDAO productDAO;

    @Autowired
    public ProductServiceImpl(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public List<Product> getProducts() {
        return productDAO.listProducts();
    }

    @Override
    public void saveProduct(Product product) {
        // Optional: Add backend validation logic here
        productDAO.saveProduct(product);
    }

    @Override
    public Product getProduct(int id) {
        return productDAO.findById(id);
    }

    @Override
    public void deleteProduct(int id) {
        productDAO.deleteProduct(id);
    }

}