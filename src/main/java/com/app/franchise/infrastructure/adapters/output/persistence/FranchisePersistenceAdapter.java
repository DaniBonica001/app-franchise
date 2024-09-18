package com.app.franchise.infrastructure.adapters.output.persistence;

import com.app.franchise.application.ports.output.IFranchisePersistencePort;
import com.app.franchise.domain.model.Franchise;
import com.app.franchise.infrastructure.adapters.output.persistence.mapper.FranchiseMapper;
import com.app.franchise.infrastructure.adapters.output.persistence.repository.FranchiseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Component
@RequiredArgsConstructor
public class FranchisePersistenceAdapter implements IFranchisePersistencePort {

    private final FranchiseRepository repository;
    private final FranchiseMapper mapper;

    @Override
    public Mono<Franchise> createFranchise(Franchise franchise) {
        return repository.save(mapper.fromFranchiseToFranchiseEntity(franchise)).map(mapper::fromFranchiseEntityToFranchise);
    }

    @Override
    public Mono<Franchise> updateFranchiseName(String franchiseId, String name) {
        return repository.findByFranchiseId(franchiseId)
                .flatMap(franchiseEntity -> {
                    franchiseEntity.setName(name);
                    return repository.save(franchiseEntity);
                })
                .map(mapper::fromFranchiseEntityToFranchise);
    }

    @Override
    public Mono<Boolean> existsFranchiseByName(String name) {
        return repository.existsByName(name);
    }

    @Override
    public Mono<Franchise> findFranchiseById(String franchiseId) {
        return repository.findByFranchiseId(franchiseId).map(mapper::fromFranchiseEntityToFranchise);
    }

    @Override
    public Flux<Franchise> getAllFranchises() {
        return repository.findAll().map(mapper::fromFranchiseEntityToFranchise);
    }
}
