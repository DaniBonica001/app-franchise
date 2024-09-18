package com.app.franchise.infrastructure.adapters.input.rest;

import com.app.franchise.domain.exception.ProductAlreadyExistsException;
import com.app.franchise.domain.exception.ProductNotFoundException;

import com.app.franchise.domain.exception.StoreAlreadyExistsException;
import com.app.franchise.domain.exception.StoreNotFoundException;
import com.app.franchise.domain.model.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

import static com.app.franchise.utils.ErrorCatalog.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ErrorResponse handleProductNotFoundException() {
        return ErrorResponse.builder()
                .code(PRODUCT_NOT_FOUND.getCode())
                .message(PRODUCT_NOT_FOUND.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
    }

    @ExceptionHandler(ProductAlreadyExistsException.class)
    public ErrorResponse handleProductDuplicatedException() {
        return ErrorResponse.builder()
                .code(PRODUCT_ALREADY_EXISTS.getCode())
                .message(PRODUCT_ALREADY_EXISTS.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
    }

    @ExceptionHandler(StoreNotFoundException.class)
    public ErrorResponse handleStoreNotFoundException() {
        return ErrorResponse.builder()
                .code(STORE_NOT_FOUND.getCode())
                .message(STORE_NOT_FOUND.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
    }

    @ExceptionHandler(StoreAlreadyExistsException.class)
    public ErrorResponse handleStoreDuplicatedException() {
        return ErrorResponse.builder()
                .code(STORE_ALREADY_EXISTS.getCode())
                .message(STORE_ALREADY_EXISTS.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
    }
}
