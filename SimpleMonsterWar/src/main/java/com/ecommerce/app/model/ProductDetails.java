package com.ecommerce.app.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @NotBlank(message = "Name is required")
    @Column(name = "name")
    private String name;

    @NotNull(message = "Expiration date is required")
    @Temporal(TemporalType.DATE)
    @Column(name = "expiration_date")
    private Date expirationDate;

    @NotBlank(message = "Manufacturer is required")
    @Column(name = "manufacturer")
    private String manufacturer;

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be positive")
    @Column(name = "price")
    private Double price;

    @Column(name = "available")
    private Boolean available;

    @OneToOne(mappedBy = "productDetails", cascade = CascadeType.ALL)
    private Product product;

    public ProductDetails(String name, Date expirationDate, String manufacturer, Double price, Boolean available) {
        this.name = name;
        this.expirationDate = expirationDate;
        this.manufacturer = manufacturer;
        this.price = price;
        this.available = available;
    }
}