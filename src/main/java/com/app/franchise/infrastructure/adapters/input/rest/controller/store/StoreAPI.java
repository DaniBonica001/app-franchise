package com.app.franchise.infrastructure.adapters.input.rest.controller.store;

import com.app.franchise.infrastructure.adapters.input.rest.dto.request.CreateStoreDTO;
import com.app.franchise.infrastructure.adapters.input.rest.dto.response.CreateStoreResponseDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping(StoreAPI.BASE_STORE_URL)
public interface StoreAPI {

    String BASE_STORE_URL = "/stores";

    @PostMapping("/v1/api")
    Mono<CreateStoreResponseDTO> createStore(@Valid @RequestBody CreateStoreDTO createStoreDTO);

    @PatchMapping("/v1/api/{storeId}/name")
    Mono<CreateStoreResponseDTO> updateStoreName(@PathVariable String storeId, @RequestBody CreateStoreDTO createStoreDTO);

    @GetMapping("/v1/api/health")
    Mono<String> health();

    @GetMapping("/v1/api/{franchiseId}")
    Flux<CreateStoreResponseDTO> getStoresByFranchiseId(@PathVariable String franchiseId);
}
