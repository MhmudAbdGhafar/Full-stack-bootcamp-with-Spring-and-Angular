package com.ecommerce.app.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToOne(
            mappedBy = "product",
            cascade = CascadeType.ALL
    )
    private ProductDetails productDetails;

    public Product(String name, ProductDetails productDetails) {
        this.name = name;
        this.productDetails = productDetails;
    }
}