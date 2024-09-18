package com.app.franchise.infrastructure.adapters.input.rest;

import com.app.franchise.infrastructure.adapters.input.rest.dto.request.CreateProductDTO;
import com.app.franchise.infrastructure.adapters.input.rest.dto.response.CreateProductResponseDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RequestMapping(ProductAPI.BASE_PRODUCT_URL)
public interface ProductAPI {

    String BASE_PRODUCT_URL = "/products";


    @PostMapping("/v1/api")
    Mono<CreateProductResponseDTO> createProduct(@Valid @RequestBody CreateProductDTO createProductDTO);

    @DeleteMapping("/v1/api/{productId}")
    ResponseEntity<Mono<Void>> deleteProduct(@PathVariable Integer productId);

    @PatchMapping("/v1/api/{productId}/stock")
    Mono<CreateProductResponseDTO> updateProductStock(@PathVariable Integer productId, @RequestBody CreateProductDTO createProductDTO);

    @PatchMapping("/v1/api/{productId}/name")
    Mono<CreateProductResponseDTO> updateProductName(@PathVariable Integer productId, @RequestBody CreateProductDTO createProductDTO);





}
