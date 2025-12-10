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

import java.util.List;

@Controller
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String getProducts(Model model) {

        model.addAttribute("products", productService.getProducts());

        return "products/list";
    }

    @GetMapping("/product")
    public String addProduct(Model model) {

        Product product = new Product();
        product.setProductDetails(new ProductDetails());

        model.addAttribute("product", product);

        return "products/add";
    }

    @PostMapping("/product")
    public String addProduct(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "products/add";
        }

        if (product.getProductDetails() != null) {
            product.getProductDetails().setProduct(product);
        }

        productService.saveProduct(product);

        return "redirect:/products";
    }

    @GetMapping("/view/{id}")
    public String viewProductDetails(@PathVariable int id, Model model) {

        model.addAttribute("product", productService.getProduct(id));

        return "products/view";
    }

    @GetMapping("/product/{id}")
    public String updateProduct(Model model, @PathVariable int id) {

        Product product = productService.getProduct(id);

        model.addAttribute("product", product);

        return "products/edit";
    }

    @PostMapping("/update")
    public String updateProduct(@Valid @ModelAttribute("product") Product product,  BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "products/edit";
        }

        if (product.getProductDetails() == null) {
            product.setProductDetails(new ProductDetails());
        }

        productService.updateProduct(product);

        return "redirect:/products";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {

        productService.deleteProduct(id);

        return "redirect:/products";
    }

    @GetMapping("/search")
    public String searchProducts(
            @RequestParam(name = "keyword") String keyword,
            Model model) {

        List<Product> results = productService.searchProducts(keyword);
        model.addAttribute("products", results);
        model.addAttribute("keyword", keyword);

        return "products/list";
    }

}