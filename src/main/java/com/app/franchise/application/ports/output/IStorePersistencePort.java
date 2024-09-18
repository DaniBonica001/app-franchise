package com.app.franchise.application.ports.output;

import com.app.franchise.domain.model.Store;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IStorePersistencePort {

    Mono<Store> createStore(Store store);
    Mono<Store> updateStoreName(String storeId, String name);
    Mono<Store> findStoreById(String storeId);
    Mono<Boolean> existsStoreByName(String name);
    Flux<Store> getStoresByFranchiseId(String franchiseId);
}
