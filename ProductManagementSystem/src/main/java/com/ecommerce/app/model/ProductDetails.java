package com.ecommerce.app.model;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "product_details")
@Getter
@Setter
@NoArgsConstructor
public class ProductDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull(message = "Expiration date is required")
    @Future(message = "Expiration date must be in the future")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "expiration_date")
    private Date expirationDate;

    @NotBlank(message = "Manufacturer is required")
    @Size(max = 100, message = "Manufacturer cannot exceed 100 characters")
    @Column(name = "manufacturer")
    private String manufacturer;

    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0")
    @Column(name = "price")
    private Double price;

    @Column(name = "available")
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