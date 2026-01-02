package com.ecommerce.app.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
@ApiModel(description = "Model for product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @ApiModelProperty(value = "Id of the product", example = "1")
    private int id;

    @NotBlank(message = "Name is required")
    @Size(max = 100, message = "Name cannot exceed 100 characters")
    @Column(name = "name")
    @ApiModelProperty(value = "Name of the Product", example = "Milk")
    private String name;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "product_details_id")
    @Valid
    private ProductDetails productDetails;

    public Product(String name, ProductDetails productDetails) {
        this.name = name;
        this.productDetails = productDetails;
    }
}