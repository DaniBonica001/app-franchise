package com.app.franchise.application.ports.output;

import com.app.franchise.domain.model.Product;
import reactor.core.publisher.Mono;

public interface IProductPersistencePort {

    Mono<Product> createProduct(Product product);
    Mono<Void> deleteProduct(Integer productId);
    Mono<Product> findProductById(Integer productId);
    Mono<Boolean> existsProductByName(String name);
    Mono<Product> updateProductStock(Integer productId, int stock);
    Mono<Product> updateProductName(Integer productId, String name);
}
