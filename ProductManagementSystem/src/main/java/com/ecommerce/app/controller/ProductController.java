package com.ecommerce.app.controller;

import com.ecommerce.app.model.Product;
import com.ecommerce.app.model.ProductDetails;
import com.ecommerce.app.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@Api(tags = "Product Controller API Documentation")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    @ApiOperation("Get All available products")
    public String getProducts(Model model) {

        model.addAttribute("products", productService.getProducts());

        return "products/list";
    }

    @GetMapping("/product")
    @ApiOperation("Show add product page")
    public String addProduct(Model model) {

        Product product = new Product();
        product.setProductDetails(new ProductDetails());

        model.addAttribute("product", product);

        return "products/add";
    }

    @PostMapping("/product")
    @ApiOperation("Add new product")
    public String addProduct(
            @Valid @ModelAttribute("product") Product product,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "products/add";
        }

        productService.saveProduct(product);

        return "redirect:/products";
    }

    @GetMapping("/view/{id}")
    @ApiOperation("View product details")
    public String viewProductDetails(@PathVariable int id, Model model) {

        model.addAttribute("product", productService.getProduct(id));

        return "products/view";
    }

    @GetMapping("/product/{id}")
    @ApiOperation("Show update product page")
    public String updateProduct(Model model, @PathVariable int id) {

        Product product = productService.getProduct(id);

        model.addAttribute("product", product);

        return "products/edit";
    }

    @PostMapping("/update")
    @ApiOperation("Update existing product")
    public String updateProduct(
            @Valid @ModelAttribute("product") Product product,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "products/edit";
        }

        productService.updateProduct(product);

        return "redirect:/products";
    }

    @DeleteMapping("/product/{id}")
    @ApiOperation("Delete existing product")
    public String deleteProduct(@PathVariable int id) {

        productService.deleteProduct(id);

        return "redirect:/products";
    }

    @GetMapping("/search")
    @ApiOperation("Search if a product exists")
    public String searchProducts(
            @RequestParam(name = "keyword") String keyword,
            Model model) {

        List<Product> results = productService.searchProducts(keyword);
        model.addAttribute("products", results);
        model.addAttribute("keyword", keyword);

        return "products/list";
    }

}