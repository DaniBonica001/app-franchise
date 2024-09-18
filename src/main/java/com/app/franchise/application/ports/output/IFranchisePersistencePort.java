package com.app.franchise.application.ports.output;

import com.app.franchise.domain.model.Franchise;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IFranchisePersistencePort {

    Mono<Franchise> createFranchise(Franchise franchise);
    Mono<Franchise> updateFranchiseName(String franchiseId, String name);
    Mono<Boolean> existsFranchiseByName(String name);
    Mono<Franchise> findFranchiseById(String franchiseId);
    Flux<Franchise> getAllFranchises();
}
