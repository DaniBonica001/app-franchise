package com.app.franchise.application.ports.input;

import com.app.franchise.domain.model.Product;
import reactor.core.publisher.Mono;

public interface IProductServicePort {

    Mono<Product> createProduct(Product product);
    Mono<Void> deleteProduct(Integer productId);
    Mono<Product> updateProductStock(Integer productId, int stock);
    Mono<Product> updateProductName(Integer productId, String name);

}
