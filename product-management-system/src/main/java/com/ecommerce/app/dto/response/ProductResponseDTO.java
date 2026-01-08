package com.ecommerce.app.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(description = "Response DTO containing product information")
public class ProductResponseDTO {

    @ApiModelProperty(value = "Unique identifier of the product", example = "1")
    private Integer id;

    @ApiModelProperty(value = "Name of the product", example = "Organic Milk")
    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "Expiration date of the product", example = "2025-12-31")
    private Date expirationDate;

    @ApiModelProperty(value = "Manufacturer of the product", example = "Dairy Farm Co.")
    private String manufacturer;

    @ApiModelProperty(value = "Price of the product", example = "4.99")
    private BigDecimal price;

    @ApiModelProperty(value = "Availability status of the product", example = "true")
    private Boolean available;
}