package com.app.franchise.application.service;


import com.app.franchise.application.ports.input.IFranchiseServicePort;
import com.app.franchise.application.ports.output.IFranchisePersistencePort;
import com.app.franchise.domain.exception.FranchiseNotFoundException;
import com.app.franchise.domain.model.Franchise;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class FranchiseService implements IFranchiseServicePort {

    private final IFranchisePersistencePort persistencePort;

    @Override
    public Mono<Franchise> createFranchise(Franchise franchise) {
        return persistencePort.existsFranchiseByName(franchise.getName())
                .flatMap(exists ->{
                    if (exists) {
                        return Mono.error(FranchiseNotFoundException::new);
                    }
                    return persistencePort.createFranchise(franchise);
                });
    }

    @Override
    public Mono<Franchise> updateFranchiseName(String franchiseId, String name) {
        return persistencePort.findFranchiseById(franchiseId)
                .flatMap(franchise -> persistencePort.updateFranchiseName(franchiseId, name))
                .switchIfEmpty(Mono.defer(() -> Mono.error(FranchiseNotFoundException::new)));
    }

    @Override
    public Flux<Franchise> getAllFranchises() {
        return persistencePort.getAllFranchises();
    }
}
