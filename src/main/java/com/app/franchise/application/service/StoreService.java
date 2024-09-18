package com.app.franchise.application.service;

import com.app.franchise.application.ports.input.IStoreServicePort;
import com.app.franchise.application.ports.output.IStorePersistencePort;
import com.app.franchise.domain.exception.StoreAlreadyExistsException;
import com.app.franchise.domain.exception.StoreNotFoundException;
import com.app.franchise.domain.model.Store;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class StoreService implements IStoreServicePort {

    private final IStorePersistencePort persistencePort;

    @Override
    public Mono<Store> createStore(Store store) {
        return persistencePort.existsStoreByName(store.getName())
                .flatMap(exists ->{
                    if (exists) {
                        return Mono.error(StoreAlreadyExistsException::new);
                    }
                    return persistencePort.createStore(store);
                });
    }

    @Override
    public Mono<Store> updateStoreName(String storeId, String name) {
        return persistencePort.findStoreById(storeId)
                .switchIfEmpty(Mono.defer(() -> Mono.error(StoreNotFoundException::new)))
                .flatMap(store -> persistencePort.updateStoreName(storeId, name));
    }

    @Override
    public Flux<Store> getStoresByFranchiseId(String franchiseId) {
        return persistencePort.getStoresByFranchiseId(franchiseId)
                .switchIfEmpty(Mono.defer(() -> Mono.error(StoreNotFoundException::new)));
    }
}
