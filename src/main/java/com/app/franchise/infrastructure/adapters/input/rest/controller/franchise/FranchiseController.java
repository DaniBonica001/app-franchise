package com.app.franchise.infrastructure.adapters.input.rest.controller.franchise;

import com.app.franchise.application.ports.input.IFranchiseServicePort;
import com.app.franchise.infrastructure.adapters.input.rest.dto.request.CreateFranchiseDTO;
import com.app.franchise.infrastructure.adapters.input.rest.dto.response.CreateFranchiseResponseDTO;
import com.app.franchise.infrastructure.adapters.input.rest.mapper.FranchiseRestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class FranchiseController implements FranchiseAPI{

    private final IFranchiseServicePort servicePort;
    private final FranchiseRestMapper mapper;

    @Override
    public Mono<CreateFranchiseResponseDTO> createFranchise(CreateFranchiseDTO createFranchiseDTO) {
        return servicePort.createFranchise(mapper.fromCreateFranchiseDTOToFranchise(createFranchiseDTO))
                .map(mapper::fromFranchiseToCreateFranchiseResponseDTO);
    }

    @Override
    public Mono<CreateFranchiseResponseDTO> updateFranchiseName(String franchiseId, CreateFranchiseDTO createFranchiseDTO) {
        return servicePort.updateFranchiseName(franchiseId, createFranchiseDTO.name())
                .map(mapper::fromFranchiseToCreateFranchiseResponseDTO);
    }

    @Override
    public Mono<String> health() {
        return Mono.just("OK");
    }

    @Override
    public Flux<CreateFranchiseResponseDTO> getFranchiseById() {
        return servicePort.getAllFranchises().map(mapper::fromFranchiseToCreateFranchiseResponseDTO);
    }
}
