package com.app.franchise.application.ports.input;

import com.app.franchise.domain.model.Franchise;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IFranchiseServicePort {

    Mono<Franchise> createFranchise(Franchise franchise);
    Mono<Franchise> updateFranchiseName(String franchiseId, String name);
    Flux<Franchise> getAllFranchises();
}
