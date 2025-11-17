package com.ecommerce.app.controller;

import com.ecommerce.app.dao.ProductDAO;
import com.ecommerce.app.model.Product;
import com.ecommerce.app.model.ProductDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
public class HomeController
{
    private ProductDAO productDAO;

    @Autowired
    public HomeController(ProductDAO productDAO)
    {
        this.productDAO = productDAO;
    }

    @RequestMapping("/")
    public String homePage()
    {

        ProductDetails productDetails = new ProductDetails("milk", new Date(), "XY", 33.3, true);
        Product product = new Product("Milk", productDetails);

        Product savedProduct = productDAO.insert(product);

        System.out.println(savedProduct);

        return "homePage";
    }
}