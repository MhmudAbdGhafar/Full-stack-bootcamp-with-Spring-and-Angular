package com.ecommerce.app.exception.global;

import com.ecommerce.app.dto.error.ProductErrorResponse;
import com.ecommerce.app.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ProductErrorResponse> HandleProductNotFound(
            ProductNotFoundException productNotFoundException) {

        ProductErrorResponse productErrorResponse = new ProductErrorResponse();
        productErrorResponse.setCode(HttpStatus.NOT_FOUND.value());
        productErrorResponse.setMessage(productNotFoundException.getMessage());
        productErrorResponse.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(productErrorResponse, HttpStatus.NOT_FOUND);
    }
}