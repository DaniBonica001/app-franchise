package com.app.franchise.infrastructure.adapters.output.persistence.repository;

import com.app.franchise.infrastructure.adapters.output.persistence.entity.ProductEntity;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface ProductRepository extends ReactiveMongoRepository<ProductEntity, Integer> {

    @Query("{ 'name' : ?0 }")
    Mono<Boolean> existsProductByName(String name);
}
