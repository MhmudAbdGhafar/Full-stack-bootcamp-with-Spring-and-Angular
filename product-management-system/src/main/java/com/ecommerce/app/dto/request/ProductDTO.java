package com.ecommerce.app.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@ApiModel(description = "Data Transfer Object for Product")
public class ProductDTO {

    @ApiModelProperty(value = "Unique identifier of the product", example = "1", accessMode = ApiModelProperty.AccessMode.READ_ONLY)
    private Integer id;

    @NotBlank(message = "Product name is required")
    @Size(min = 2, max = 100, message = "Product name must be between 2 and 100 characters")
    @ApiModelProperty(value = "Name of the product", example = "Organic Milk", required = true)
    private String name;

    @Valid
    @NotNull(message = "Product details are required")
    @ApiModelProperty(value = "Details of the product", required = true)
    private ProductDetailsDTO productDetails;
}