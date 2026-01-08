package com.ecommerce.app.controller;

import com.ecommerce.app.dto.request.ProductDTO;
import com.ecommerce.app.dto.response.ProductResponseDTO;
import com.ecommerce.app.exception.ProductNotFoundException;
import com.ecommerce.app.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@Validated
@Api(tags = "Product Management", description = "Operations for managing products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("products")
    @ApiOperation(value = "Get all products", response = ProductResponseDTO.class, responseContainer = "List")
    public ResponseEntity<List<ProductResponseDTO>> getAllProducts() {

        List<ProductResponseDTO> responseDTOs = productService.getProducts();

        return ResponseEntity.ok(responseDTOs);
    }

    @GetMapping("product")
    @ApiOperation(value = "Get product by ID", response = ProductResponseDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Product found"),
            @ApiResponse(code = 404, message = "Product not found")
    })
    public ResponseEntity<ProductResponseDTO> getProductById(@RequestParam("id") Integer id)
            throws ProductNotFoundException {

        ProductResponseDTO responseDTO = productService.getProduct(id);

        return ResponseEntity.ok(responseDTO);
    }

    @PostMapping("product")
    @ApiOperation(value = "Create a new product", response = ProductResponseDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Product created successfully"),
            @ApiResponse(code = 400, message = "Invalid input data")
    })
    public ResponseEntity<ProductResponseDTO> createProduct(
            @Valid @RequestBody ProductDTO requestDTO) {

        ProductResponseDTO responseDTO = productService.saveProduct(requestDTO);

        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @PutMapping("product")
    @ApiOperation(value = "Update an existing product", response = ProductResponseDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Product updated successfully"),
            @ApiResponse(code = 404, message = "Product not found"),
            @ApiResponse(code = 400, message = "Invalid input data")
    })
    public ResponseEntity<ProductResponseDTO> updateProduct(
            @Valid @RequestBody ProductDTO updateDTO) {

        ProductResponseDTO responseDTO = productService.updateProduct(updateDTO);

        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("product")
    @ApiOperation(value = "Delete a product")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Product deleted successfully"),
            @ApiResponse(code = 404, message = "Product not found")
    })
    public ResponseEntity<ProductResponseDTO> deleteProduct(@RequestParam("id") Integer id)
            throws ProductNotFoundException {

        ProductResponseDTO productResponseDTO = productService.deleteProduct(id);

        return ResponseEntity.ok(productResponseDTO);
    }
}