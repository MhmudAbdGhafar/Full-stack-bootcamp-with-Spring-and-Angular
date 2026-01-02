package com.ecommerce.app.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Setter
@Getter
@ApiModel(description = "Model for product")
public class ProductDTO {

    @ApiModelProperty(value = "Id of the product", example = "1")
    private int id;

    @NotBlank(message = "Product name is required")
    @Size(max = 100, message = "Name cannot exceed 100 characters")
    @ApiModelProperty(value = "Name of the Product", example = "Milk")
    private String name;

    @Valid
    private ProductDetailsDTO productDetails;

}