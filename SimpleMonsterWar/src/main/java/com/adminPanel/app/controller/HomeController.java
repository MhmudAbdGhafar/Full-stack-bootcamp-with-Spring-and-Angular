package com.adminPanel.app.controller;

import com.adminPanel.app.dao.ProductDAO;
import com.adminPanel.app.dao.ProductDAOImpl;
import com.adminPanel.app.model.Product;
import com.adminPanel.app.model.ProductDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
public class HomeController
{
    @RequestMapping("/")
    public String homePage()
    {
        ProductDAO productDAO = new ProductDAOImpl();

        ProductDetails productDetails = new ProductDetails("milk", new Date(), "XY", 33.3, true);
        Product product = new Product("Milk", productDetails);

        Product savedProduct = productDAO.insert(product);

        System.out.println(savedProduct);

        return "homePage";
    }
}