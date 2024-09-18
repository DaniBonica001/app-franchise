package com.app.franchise.infrastructure.adapters.output.persistence;

import com.app.franchise.application.ports.output.IProductPersistencePort;
import com.app.franchise.domain.model.Product;
import com.app.franchise.infrastructure.adapters.output.persistence.mapper.ProductPersistenceMapper;
import com.app.franchise.infrastructure.adapters.output.persistence.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class ProductPersistenceAdapter implements IProductPersistencePort {

    private final ProductRepository repository;
    private final ProductPersistenceMapper mapper;

    @Override
    public Mono<Product> createProduct(Product product) {
        return repository.save(mapper.fromProductToProductEntity(product)).map(mapper::fromProductEntityToProduct);
    }

    @Override
    public Mono<Void> deleteProduct(String productId) {
        return repository.deleteByProductId(productId);
    }

    @Override
    public Mono<Product> findProductById(String productId) {
        return repository.findByProductId(productId).map(mapper::fromProductEntityToProduct);
    }

    @Override
    public Mono<Boolean> existsProductByName(String name) {
        return repository.existsByName(name);
    }

    @Override
    public Mono<Product> updateProductStock(String productId, int stock) {

        return findProductById(productId)
                .flatMap(product -> {
                    product.setStock(stock);
                    return repository.save(mapper.fromProductToProductEntity(product));
                })
                .map(mapper::fromProductEntityToProduct);
    }

    @Override
    public Mono<Product> updateProductName(String productId, String name) {
        return findProductById(productId)
                .flatMap(product -> {
                    product.setName(name);
                    return repository.save(mapper.fromProductToProductEntity(product));
                })
                .map(mapper::fromProductEntityToProduct);
    }
}
