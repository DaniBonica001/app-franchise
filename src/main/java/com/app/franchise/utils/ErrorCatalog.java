package com.app.franchise.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCatalog {

    PRODUCT_NOT_FOUND("ERR_PRODUCT_404", "Product not found"),
    PRODUCT_ALREADY_EXISTS("ERR_PRODUCT_409", "Product already exists"),
    STORE_NOT_FOUND("ERR_STORE_404", "Store not found"),
    STORE_ALREADY_EXISTS("ERR_STORE_409", "Store already exists");

    private final String code;
    private final String message;
}
