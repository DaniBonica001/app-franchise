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
    public Mono<Void> deleteProduct(Integer productId) {
        return repository.deleteById(productId);
    }

    @Override
    public Mono<Product> findProductById(Integer productId) {
        return repository.findById(productId).map(mapper::fromProductEntityToProduct);
    }

    @Override
    public Mono<Boolean> existsProductByName(String name) {
        return repository.existsProductByName(name);
    }

    @Override
    public Mono<Product> updateProductStock(Integer productId, int stock) {
        return repository.findById(productId)
                .flatMap(productEntity -> {
                    productEntity.setStock(stock);
                    return repository.save(productEntity);
                })
                .map(mapper::fromProductEntityToProduct);
    }

    @Override
    public Mono<Product> updateProductName(Integer productId, String name) {
        return repository.findById(productId)
                .flatMap(productEntity -> {
                    productEntity.setName(name);
                    return repository.save(productEntity);
                })
                .map(mapper::fromProductEntityToProduct);
    }
}
