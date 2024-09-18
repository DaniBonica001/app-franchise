package com.app.franchise.application.ports.input;

import com.app.franchise.domain.model.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IProductServicePort {

    Mono<Product> createProduct(Product product);
    Mono<Void> deleteProduct(String productId);
    Mono<Product> updateProductStock(String productId, int stock);
    Mono<Product> updateProductName(String productId, String name);
    Flux<Product> getProductsByStoreId(String storeId);

}
