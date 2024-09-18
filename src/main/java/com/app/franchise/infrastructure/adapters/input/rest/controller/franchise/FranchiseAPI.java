package com.app.franchise.infrastructure.adapters.input.rest.controller.franchise;

import com.app.franchise.infrastructure.adapters.input.rest.dto.request.CreateFranchiseDTO;
import com.app.franchise.infrastructure.adapters.input.rest.dto.response.CreateFranchiseResponseDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping(FranchiseAPI.BASE_FRANCHISE_URL)
public interface FranchiseAPI {

    String BASE_FRANCHISE_URL = "/franchises";

    @PostMapping("/v1/api")
    Mono<CreateFranchiseResponseDTO> createFranchise(@Valid @RequestBody CreateFranchiseDTO createFranchiseDTO);

    @PatchMapping("/v1/api/{franchiseId}/name")
    Mono<CreateFranchiseResponseDTO> updateFranchiseName(@PathVariable String franchiseId, CreateFranchiseDTO createFranchiseDTO);

    @GetMapping("/v1/api/health")
    Mono<String> health();

    @GetMapping("/v1/api/all")
    Flux<CreateFranchiseResponseDTO> getFranchiseById();
}
