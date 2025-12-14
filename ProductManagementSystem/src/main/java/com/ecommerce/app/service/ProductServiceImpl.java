package com.ecommerce.app.service;

import com.ecommerce.app.dao.ProductDAO;
import com.ecommerce.app.model.Product;
import org.hibernate.Hibernate;
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
        productDAO.saveProduct(product);
    }

    @Override
    public void updateProduct(Product product) {
        productDAO.updateProduct(product);
    }

    @Override
    public Product getProduct(int id) {

        Product product = productDAO.findById(id);

        Hibernate.initialize(product.getProductDetails());

        return productDAO.findById(id);
    }

    @Override
    public void deleteProduct(int id) {
        productDAO.deleteProduct(id);
    }

    @Override
    public List<Product> searchProducts(String keyword) {

        if (keyword == null || keyword.trim().isEmpty()) {
            return productDAO.listProducts();
        }

        return productDAO.searchProductsByName(keyword);
    }

}