package com.ecommerce.app.controller;

import com.ecommerce.app.model.Product;
import com.ecommerce.app.model.ProductDetails;
import com.ecommerce.app.service.ProductService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/list")
    public String listProducts(Model model) {

        model.addAttribute("products", service.getProducts());

        return "products";
    }

    @GetMapping("/add")
    public String addForm(Model model) {

        model.addAttribute("product", new Product());
        model.addAttribute("details", new ProductDetails());

        return "add-product";
    }

    @PostMapping("/save")
    public String saveProduct(
            @Valid @ModelAttribute("product") Product product,
            @ModelAttribute("details") ProductDetails details,
            BindingResult result) {

        if (result.hasErrors()) {
            return "add-product";
        }

        product.setProductDetails(details);

        service.saveProduct(product);

        return "redirect:/products/list";
    }

    @GetMapping("/update/{id}")
    public String updateForm(@PathVariable int id, Model model) {

        Product product = service.getProduct(id);

        model.addAttribute("product", product);
        model.addAttribute("details", product.getProductDetails());

        return "update-product";
    }

    @PostMapping("/update")
    public String updateProduct(
            @Valid @ModelAttribute("product") Product product,
            @ModelAttribute("details") ProductDetails details,
            BindingResult result) {

        if (result.hasErrors()) {
            return "update-product";
        }

        product.setProductDetails(details);
        service.saveProduct(product);

        return "redirect:/products/list";
    }

    @GetMapping("/view/{id}")
    public String viewProduct(@PathVariable int id, Model model) {

        model.addAttribute("product", service.getProduct(id));

        return "view-product";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {

        service.deleteProduct(id);

        return "redirect:/products/list";
    }
}