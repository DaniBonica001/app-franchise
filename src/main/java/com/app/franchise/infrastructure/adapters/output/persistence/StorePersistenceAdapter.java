package com.app.franchise.infrastructure.adapters.output.persistence;

import com.app.franchise.application.ports.output.IStorePersistencePort;
import com.app.franchise.domain.model.Store;
import com.app.franchise.infrastructure.adapters.output.persistence.mapper.StorePersistenceMapper;
import com.app.franchise.infrastructure.adapters.output.persistence.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class StorePersistenceAdapter implements IStorePersistencePort {

    private final StoreRepository repository;
    private final StorePersistenceMapper mapper;

    @Override
    public Mono<Store> createStore(Store store) {
        return repository.save(mapper.fromStoreToStoreEntity(store)).map(mapper::fromStoreEntityToStore);
    }

    @Override
    public Mono<Store> updateStoreName(String storeId, String name) {
        return repository.findByStoreId(storeId)
                .flatMap(storeEntity -> {
                    storeEntity.setName(name);
                    return repository.save(storeEntity);
                })
                .map(mapper::fromStoreEntityToStore);
    }

    @Override
    public Mono<Store> findStoreById(String storeId) {
        return repository.findByStoreId(storeId).map(mapper::fromStoreEntityToStore);
    }


    @Override
    public Mono<Boolean> existsStoreByName(String name) {
        return repository.existsByName(name);
    }

    @Override
    public Flux<Store> getStoresByFranchiseId(String franchiseId) {
        return repository.findByFranchiseId(franchiseId).map(mapper::fromStoreEntityToStore);
    }
}
