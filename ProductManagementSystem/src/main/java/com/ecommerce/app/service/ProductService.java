package com.ecommerce.app.service;

import com.ecommerce.app.dto.ProductDTO;

import java.util.List;

public interface ProductService {

    List<ProductDTO> getProducts();

    ProductDTO getProduct(int id);

    void saveProduct(ProductDTO productDTO);

    void updateProduct(ProductDTO productDTO);

    void deleteProduct(int id);

    List<ProductDTO> searchProducts(String keyword);
}
