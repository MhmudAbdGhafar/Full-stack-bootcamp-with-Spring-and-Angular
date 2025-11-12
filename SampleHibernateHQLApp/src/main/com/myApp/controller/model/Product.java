package main.com.myApp.controller.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "products")
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int productId;

    @Column(name = "name")
    private String productName;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private double price;

    @Column(name = "stock_quantity")
    private int stockQuantity;

    @Column(name = "manufacturer")
    private String manufacturerName;

    @Column(name = "production_date")
    @Temporal(TemporalType.DATE)
    private Date productionDate;

    public Product(String productName, String description, double price, int stockQuantity, String manufacturerName, Date productionDate) {
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.manufacturerName = manufacturerName;
        this.productionDate = productionDate;
    }
}