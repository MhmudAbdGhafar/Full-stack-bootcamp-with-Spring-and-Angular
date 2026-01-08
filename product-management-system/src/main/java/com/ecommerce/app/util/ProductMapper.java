package com.ecommerce.app.util;

import com.ecommerce.app.dto.request.ProductDTO;
import com.ecommerce.app.dto.response.ProductResponseDTO;
import com.ecommerce.app.entity.Product;
import com.ecommerce.app.entity.ProductDetails;

public class ProductMapper {

    public static Product toEntity(ProductDTO dto) {
        if (dto == null) {
            return null;
        }

        Product entity = Product.builder().name(dto.getName()).build();

        if (dto.getProductDetails() != null) {
            ProductDetails details = ProductDetails.builder()
                    .expirationDate(dto.getProductDetails().getExpirationDate())
                    .manufacturer(dto.getProductDetails().getManufacturer())
                    .price(dto.getProductDetails().getPrice())
                    .available(dto.getProductDetails().getAvailable())
                    .build();

            entity.setProductDetails(details);
            details.setProduct(entity);
        }

        return entity;
    }

    public static Product updateEntity(ProductDTO dto) {
        if (dto == null) {
            return null;
        }

        Product entity = Product.builder()
                .id(dto.getId())
                .name(dto.getName())
                .build();

        if (dto.getProductDetails() != null) {
            ProductDetails details = ProductDetails.builder()
                    .id(dto.getProductDetails().getId())
                    .expirationDate(dto.getProductDetails().getExpirationDate())
                    .manufacturer(dto.getProductDetails().getManufacturer())
                    .price(dto.getProductDetails().getPrice())
                    .available(dto.getProductDetails().getAvailable())
                    .build();

            entity.setProductDetails(details);
            details.setProduct(entity);
        }

        return entity;
    }

    public static ProductResponseDTO toResponseDTO(Product entity) {
        if (entity == null || entity.getProductDetails() == null) {
            return null;
        }

        return ProductResponseDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .expirationDate(entity.getProductDetails().getExpirationDate())
                .manufacturer(entity.getProductDetails().getManufacturer())
                .price(entity.getProductDetails().getPrice())
                .available(entity.getProductDetails().getAvailable())
                .build();
    }
}