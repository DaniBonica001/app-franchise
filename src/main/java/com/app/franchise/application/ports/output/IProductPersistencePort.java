package com.app.franchise.application.ports.output;

import com.app.franchise.domain.model.Product;
import reactor.core.publisher.Mono;

public interface IProductPersistencePort {

    Mono<Product> createProduct(Product product);
    Mono<Void> deleteProduct(String productId);
    Mono<Product> findProductById(String productId);
    Mono<Boolean> existsProductByName(String name);
    Mono<Product> updateProductStock(String productId, int stock);
    Mono<Product> updateProductName(String productId, String name);
}
