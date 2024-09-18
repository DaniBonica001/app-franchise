package com.app.franchise.infrastructure.adapters.output.persistence.repository;

import com.app.franchise.infrastructure.adapters.output.persistence.entity.ProductEntity;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface ProductRepository extends ReactiveMongoRepository<ProductEntity, Integer> {
    Mono<Boolean> existsByName(String name);

    Mono<ProductEntity> findByProductId(String productId);

    Mono<Void> deleteByProductId(String productId);

    Flux<ProductEntity> findByStoreId(String storeId);
}
