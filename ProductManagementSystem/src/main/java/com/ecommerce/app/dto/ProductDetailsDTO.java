package com.ecommerce.app.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;

@Setter
@Getter
@ApiModel("Model for product details")
public class ProductDetailsDTO {

    @NotNull(message = "Expiration date is required")
    @Future(message = "Expiration date must be in the future")
    @ApiModelProperty(value = "Date when the product is expired", example = "2025/04/04")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date expirationDate;

    @NotBlank(message = "Manufacturer is required")
    @Size(max = 100, message = "Manufacturer cannot exceed 100 characters")
    @ApiModelProperty(value = "Manufacturer who creates this product", example = "Dina Farms")
    private String manufacturer;

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be greater than zero")
    @ApiModelProperty(value = "Price of the product", example = "55.6")
    private double price;

    @ApiModelProperty(value = "Is the product is available to buy?", example = "1 or 0")
    private boolean available;

}