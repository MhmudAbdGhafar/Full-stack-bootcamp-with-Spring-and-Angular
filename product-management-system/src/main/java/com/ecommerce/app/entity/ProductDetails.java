package com.ecommerce.app.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "product_details")
public class ProductDetails {

    @Id
    private int id; // Same as product id

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "expiration_date")
    private Date expirationDate;

    @Column(length = 100)
    private String manufacturer;

    @Column(precision = 10, scale = 2)
    private BigDecimal price;

    @Column(nullable = false)
    private Boolean available = true;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId  // This makes ProductDetails use Product's ID
    @JoinColumn(name = "product_id")
    private Product product;
}