package com.app.franchise.application.service;

import com.app.franchise.application.ports.input.IProductServicePort;
import com.app.franchise.application.ports.output.IProductPersistencePort;
import com.app.franchise.domain.exception.ProductException;
import com.app.franchise.domain.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductServicePort {

    private final IProductPersistencePort persistencePort;

    @Override
    public Mono<Product> createProduct(Product product) {
        return persistencePort.existsProductByName(product.getName())
                .flatMap(exists ->{
                    if (exists) {
                        return Mono.error(new ProductException("Product already exists: "+ product.getName(), HttpStatus.CONFLICT));
                    }
                    return persistencePort.createProduct(product);
                });

    }

    @Override
    public Mono<Void> deleteProduct(Integer productId) {
        return getMonoProductById(productId)
                .flatMap(product -> persistencePort.deleteProduct(productId));

    }

    @Override
    public Mono<Product> updateProductStock(Integer productId, int stock) {
        return getMonoProductById(productId)
                .flatMap(product -> persistencePort.updateProductStock(productId, stock));
    }

    @Override
    public Mono<Product> updateProductName(Integer productId, String name) {
        return getMonoProductById(productId)
                .flatMap(product -> persistencePort.updateProductName(productId, name));
    }

    private Mono<Product> getMonoProductById(Integer productId) {
        return persistencePort.findProductById(productId)
                .switchIfEmpty(Mono.defer(() -> {
                    return Mono.error(new ProductException("Product not found: "+ productId, HttpStatus.NOT_FOUND));
                        }));
    }
}
