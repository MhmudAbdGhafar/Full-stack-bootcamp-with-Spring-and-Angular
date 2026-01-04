package com.ecommerce.app.service;

import com.ecommerce.app.dao.ProductDAO;
import com.ecommerce.app.dto.ProductDTO;
import com.ecommerce.app.entity.Product;
import com.ecommerce.app.entity.ProductDetails;
import com.ecommerce.app.mapper.ProductMapper;
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
    public List<ProductDTO> getProducts() {
        return productDAO.findAll()
                .stream()
                .map(ProductMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO getProduct(int id) {

        Product product = productDAO.findById(id);

        return ProductMapper.toDTO(product);
    }

    @Override
    public void saveProduct(ProductDTO productDTO) {

        Product product = ProductMapper.toEntity(productDTO);

        ProductDetails details = product.getProductDetails();

        if (details == null) {
            details = new ProductDetails();
        }

        product.setProductDetails(details);
        product.getProductDetails().setProduct(product);

        productDAO.save(product);
    }

    @Override
    public void updateProduct(ProductDTO productDTO) {

        Product existingProduct = productDAO.findById(productDTO.getId());

        Product product = ProductMapper.updateEntity(existingProduct, productDTO);

        productDAO.update(product);
    }

    @Override
    public void deleteProduct(int id) {
        productDAO.delete(id);
    }

    @Override
    public List<ProductDTO> searchProducts(String keyword) {

        if (keyword == null || keyword.trim().isEmpty()) {
            return productDAO.findAll()
                    .stream()
                    .map(ProductMapper::toDTO)
                    .collect(Collectors.toList());
        }

        return productDAO.search(keyword)
                .stream()
                .map(ProductMapper::toDTO)
                .collect(Collectors.toList());
    }
}