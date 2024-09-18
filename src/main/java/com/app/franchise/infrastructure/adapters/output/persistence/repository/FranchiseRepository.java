package com.app.franchise.infrastructure.adapters.output.persistence.repository;

import com.app.franchise.infrastructure.adapters.output.persistence.entity.FranchiseEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface FranchiseRepository extends ReactiveMongoRepository<FranchiseEntity, Integer> {

    Mono<Boolean> existsByName(String name);

    Mono<FranchiseEntity> findByFranchiseId(String franchiseId);


}
