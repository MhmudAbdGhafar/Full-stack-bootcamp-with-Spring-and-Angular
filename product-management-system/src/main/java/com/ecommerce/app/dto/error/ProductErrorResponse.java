package com.ecommerce.app.dto.error;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductErrorResponse {

    private int code;

    private String message;

    private long timestamp;

}