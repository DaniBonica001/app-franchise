package com.app.franchise.infrastructure.adapters.input.rest.dto.response;

import com.app.franchise.infrastructure.adapters.input.rest.dto.request.CreateStoreDTO;
import lombok.Builder;

import java.util.List;

@Builder
public record CreateFranchiseResponseDTO(
        String franchiseId,
        String name,
        List<CreateStoreDTO> stores


) {
}
