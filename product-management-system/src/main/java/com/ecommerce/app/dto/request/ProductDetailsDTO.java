package com.ecommerce.app.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@ApiModel(description = "Data Transfer Object for Product Details")
public class ProductDetailsDTO {

    @ApiModelProperty(value = "Unique identifier of product details", example = "1", accessMode = ApiModelProperty.AccessMode.READ_ONLY)
    private Integer id;

    @Future(message = "Expiration date must be in the future")
    @NotNull(message = "Expiration date is required")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "Expiration date of the product", example = "2025-12-31", required = true)
    private Date expirationDate;

    @NotBlank(message = "Manufacturer name is required")
    @Size(max = 100, message = "Manufacturer name cannot exceed 100 characters")
    @ApiModelProperty(value = "Manufacturer of the product", example = "Dairy Farm Co.", required = true)
    private String manufacturer;

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be greater than zero")
    @DecimalMin(value = "0.01", message = "Price must be at least 0.01")
    @DecimalMax(value = "999999.99", message = "Price cannot exceed 999999.99")
    @Digits(integer = 6, fraction = 2, message = "Price must have maximum 6 digits and 2 decimal places")
    @ApiModelProperty(value = "Price of the product", example = "4.99", required = true)
    private BigDecimal price;

    @NotNull(message = "Availability status is required")
    @ApiModelProperty(value = "Availability status of the product", example = "true", required = true)
    private Boolean available;
}