package com.ecommerce.app.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
@Table(name = "product_details")
@Getter
@Setter
@NoArgsConstructor
@ApiModel("Model for product details")
public class ProductDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @ApiModelProperty(value = "Id of the product", example = "1")
    private int id;

    @NotNull(message = "Expiration date is required")
    @Future(message = "Expiration date must be in the future")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "expiration_date")
    @ApiModelProperty(value = "Date when the product is expired", example = "2025/04/04")
    private Date expirationDate;

    @NotBlank(message = "Manufacturer is required")
    @Size(max = 100, message = "Manufacturer cannot exceed 100 characters")
    @Column(name = "manufacturer")
    @ApiModelProperty(value = "Manufacturer who creates this product", example = "Dina Farms")
    private String manufacturer;

    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0")
    @Column(name = "price")
    @ApiModelProperty(value = "Price of the product", example = "55.6")
    private Double price;

    @Column(name = "available")
    @ApiModelProperty(value = "Is the product is available to buy?", example = "1 or 0")
    private Boolean available;

    @OneToOne(mappedBy = "productDetails")
    private Product product;

    public ProductDetails(Date expirationDate, String manufacturer, Double price, Boolean available) {
        this.expirationDate = expirationDate;
        this.manufacturer = manufacturer;
        this.price = price;
        this.available = available;
    }
}