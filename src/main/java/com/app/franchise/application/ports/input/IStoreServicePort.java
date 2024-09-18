package com.app.franchise.application.ports.input;

import com.app.franchise.domain.model.Store;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IStoreServicePort {

    Mono<Store> createStore(Store store);
    Mono<Store> updateStoreName(String storeId, String name);
    Flux<Store> getStoresByFranchiseId(String franchiseId);
}
