package com.ecommerce.app.service;

import com.ecommerce.app.dto.request.ProductDTO;
import com.ecommerce.app.dto.response.ProductResponseDTO;
import com.ecommerce.app.exception.ProductNotFoundException;

import java.util.List;

public interface ProductService {

    List<ProductResponseDTO> getProducts();

    ProductResponseDTO getProduct(int id) throws ProductNotFoundException;

    ProductResponseDTO saveProduct(ProductDTO productDTO);

    ProductResponseDTO updateProduct(ProductDTO productDTO);

    ProductResponseDTO deleteProduct(int id) throws ProductNotFoundException;
}
