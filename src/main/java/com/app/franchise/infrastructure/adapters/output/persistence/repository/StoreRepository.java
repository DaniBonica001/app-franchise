package com.app.franchise.infrastructure.adapters.output.persistence.repository;

import com.app.franchise.infrastructure.adapters.output.persistence.entity.StoreEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StoreRepository extends ReactiveMongoRepository<StoreEntity, Integer> {

    Mono<Boolean> existsByName(String name);

    Mono<StoreEntity> findByStoreId(String storeId);

    Flux<StoreEntity> findByFranchiseId(String franchiseId);


}
