package com.ecommerce.app.mapper;

import com.ecommerce.app.dto.ProductDTO;
import com.ecommerce.app.dto.ProductDetailsDTO;
import com.ecommerce.app.entity.Product;
import com.ecommerce.app.entity.ProductDetails;

public class ProductMapper {

    public static ProductDTO toDTO(Product entity) {
        ProductDTO dto = new ProductDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());

        ProductDetailsDTO detailsDTO = new ProductDetailsDTO();
        detailsDTO.setExpirationDate(entity.getProductDetails().getExpirationDate());
        detailsDTO.setManufacturer(entity.getProductDetails().getManufacturer());
        detailsDTO.setPrice(entity.getProductDetails().getPrice());
        detailsDTO.setAvailable(entity.getProductDetails().getAvailable());

        dto.setProductDetails(detailsDTO);

        return dto;
    }

    public static Product toEntity(ProductDTO dto) {
        Product entity = new Product();
        entity.setId(dto.getId());
        entity.setName(dto.getName());

        ProductDetails details = new ProductDetails();
        details.setExpirationDate(dto.getProductDetails().getExpirationDate());
        details.setManufacturer(dto.getProductDetails().getManufacturer());
        details.setPrice(dto.getProductDetails().getPrice());
        details.setAvailable(dto.getProductDetails().isAvailable());

        entity.setProductDetails(details);

        return entity;
    }

    public static Product updateEntity(Product entity, ProductDTO dto) {
        entity.setId(dto.getId());
        entity.setName(dto.getName());

        ProductDetails details = entity.getProductDetails();

        if (details == null) {
            details = new ProductDetails();
        }

        details.setExpirationDate(dto.getProductDetails().getExpirationDate());
        details.setManufacturer(dto.getProductDetails().getManufacturer());
        details.setPrice(dto.getProductDetails().getPrice());
        details.setAvailable(dto.getProductDetails().isAvailable());

        entity.setProductDetails(details);

        return entity;
    }
}