package com.app.franchise.infrastructure.adapters.input.rest.controller.product;

import com.app.franchise.application.ports.input.IProductServicePort;
import com.app.franchise.infrastructure.adapters.input.rest.dto.request.CreateProductDTO;
import com.app.franchise.infrastructure.adapters.input.rest.dto.response.CreateProductResponseDTO;
import com.app.franchise.infrastructure.adapters.input.rest.mapper.ProductRestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class ProductController implements ProductAPI{

    private final IProductServicePort servicePort;
    private final ProductRestMapper mapper;

    @Override
    public Mono<CreateProductResponseDTO> createProduct(CreateProductDTO createProductDTO) {
        return servicePort.createProduct(mapper.fromCreateProductDTOToProduct(createProductDTO))
                .map(mapper::fromProductToCreateProductResponseDTO);
    }

    @Override
    public ResponseEntity<Mono<Void>> deleteProduct(String productId) {
        return new ResponseEntity<>(servicePort.deleteProduct(productId), HttpStatus.OK);
    }

    @Override
    public Mono<CreateProductResponseDTO> updateProductStock(String productId, CreateProductDTO createProductDTO) {
        return servicePort.updateProductStock(productId, createProductDTO.stock())
                .map(mapper::fromProductToCreateProductResponseDTO);
    }

    @Override
    public Mono<CreateProductResponseDTO> updateProductName(String productId, CreateProductDTO createProductDTO) {
        return servicePort.updateProductName(productId, createProductDTO.name())
                .map(mapper::fromProductToCreateProductResponseDTO);
    }

    @Override
    public Mono<String> health() {
        return Mono.just("OK");
    }

    @Override
    public Flux<CreateProductResponseDTO> getProductsByStoreId(String storeId) {
        return servicePort.getProductsByStoreId(storeId).map(mapper::fromProductToCreateProductResponseDTO);
    }
}
