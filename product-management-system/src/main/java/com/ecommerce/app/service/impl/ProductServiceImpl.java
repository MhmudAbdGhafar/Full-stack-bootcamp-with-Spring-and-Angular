package com.ecommerce.app.service.impl;

import com.ecommerce.app.dao.ProductDAO;
import com.ecommerce.app.dto.request.ProductDTO;
import com.ecommerce.app.dto.response.ProductResponseDTO;
import com.ecommerce.app.entity.Product;
import com.ecommerce.app.exception.ProductNotFoundException;
import com.ecommerce.app.service.ProductService;
import com.ecommerce.app.util.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private ProductDAO productDAO;

    @Autowired
    public ProductServiceImpl(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public List<ProductResponseDTO> getProducts() {
        return productDAO.findAll()
                .stream()
                .map(ProductMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProductResponseDTO getProduct(int id)
            throws ProductNotFoundException {

        Product product = productDAO.findById(id);

        if(id < 0 || product == null){
            throw new ProductNotFoundException("Product not found");
        }

        return ProductMapper.toResponseDTO(product);
    }

    @Override
    public ProductResponseDTO saveProduct(ProductDTO productDTO) {

        Product product = ProductMapper.toEntity(productDTO);

        Product savedProduct = productDAO.save(product);

        return ProductMapper.toResponseDTO(savedProduct);
    }

    @Override
    public ProductResponseDTO updateProduct(ProductDTO productDTO) {

        Product product = ProductMapper.updateEntity(productDTO);

        Product updatedProduct = productDAO.update(product);

        return ProductMapper.toResponseDTO(updatedProduct);
    }

    @Override
    public ProductResponseDTO deleteProduct(int id) throws ProductNotFoundException {

        Product deletedProduct = productDAO.delete(id);

        if(id <= 0 || deletedProduct == null){
            throw new ProductNotFoundException("Product not found");
        }

        return ProductMapper.toResponseDTO(deletedProduct);
    }
}