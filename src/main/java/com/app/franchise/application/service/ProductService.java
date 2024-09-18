package com.app.franchise.application.service;

import com.app.franchise.application.ports.input.IProductServicePort;
import com.app.franchise.application.ports.output.IProductPersistencePort;
import com.app.franchise.domain.exception.ProductAlreadyExistsException;
import com.app.franchise.domain.exception.ProductNotFoundException;
import com.app.franchise.domain.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
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
                        return Mono.error(ProductAlreadyExistsException::new);
                    }
                    return persistencePort.createProduct(product);
                });

    }

    @Override
    public Mono<Void> deleteProduct(String productId) {
        return getMonoProductById(productId)
                .flatMap(product -> persistencePort.deleteProduct(productId));

    }

    @Override
    public Mono<Product> updateProductStock(String productId, int stock) {
        return getMonoProductById(productId)
                .flatMap(product -> persistencePort.updateProductStock(productId, stock));
    }

    @Override
    public Mono<Product> updateProductName(String productId, String name) {
        return getMonoProductById(productId)
                .flatMap(product -> persistencePort.updateProductName(productId, name));
    }

    @Override
    public Flux<Product> getProductsByStoreId(String storeId) {
        return persistencePort.getProductsByStoreId(storeId)
                .switchIfEmpty(Mono.defer(() -> Mono.error(ProductNotFoundException::new)));
    }

    private Mono<Product> getMonoProductById(String productId) {
        return persistencePort.findProductById(productId)
                .switchIfEmpty(Mono.defer(() -> Mono.error(ProductNotFoundException::new)));
    }


}
