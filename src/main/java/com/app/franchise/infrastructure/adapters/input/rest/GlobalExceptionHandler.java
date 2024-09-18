package com.app.franchise.infrastructure.adapters.input.rest;

import com.app.franchise.domain.exception.ProductAlreadyExistsException;
import com.app.franchise.domain.exception.ProductNotFoundException;

import com.app.franchise.domain.model.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

import static com.app.franchise.utils.ErrorCatalog.PRODUCT_ALREADY_EXISTS;
import static com.app.franchise.utils.ErrorCatalog.PRODUCT_NOT_FOUND;

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
}
