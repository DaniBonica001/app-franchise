package com.app.franchise.infrastructure.adapters.input.rest.controller.store;

import com.app.franchise.application.ports.input.IStoreServicePort;
import com.app.franchise.infrastructure.adapters.input.rest.dto.request.CreateStoreDTO;
import com.app.franchise.infrastructure.adapters.input.rest.dto.response.CreateStoreResponseDTO;
import com.app.franchise.infrastructure.adapters.input.rest.mapper.StoreRestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class StoreController implements StoreAPI{

    private final IStoreServicePort servicePort;
    private final StoreRestMapper mapper;

    @Override
    public Mono<CreateStoreResponseDTO> createStore(CreateStoreDTO createStoreDTO) {
        return servicePort.createStore(mapper.fromCreateStoreDTOToStore(createStoreDTO))
                .map(mapper::fromStoreToCreateStoreResponseDTO);
    }

    @Override
    public Mono<CreateStoreResponseDTO> updateStoreName(String storeId, CreateStoreDTO createStoreDTO) {
        return servicePort.updateStoreName(storeId, createStoreDTO.name())
                .map(mapper::fromStoreToCreateStoreResponseDTO);
    }

    @Override
    public Mono<String> health() {
        return Mono.just("OK");
    }

    @Override
    public Flux<CreateStoreResponseDTO> getStoresByFranchiseId(String franchiseId) {
        return servicePort.getStoresByFranchiseId(franchiseId).map(mapper::fromStoreToCreateStoreResponseDTO);
    }
}
