package com.app.franchise.infrastructure.adapters.input.rest.dto.response;

import com.app.franchise.infrastructure.adapters.input.rest.dto.request.CreateProductDTO;
import lombok.Builder;

import java.util.List;

@Builder
public record CreateStoreResponseDTO(
        String storeId,
        String name,
        List<CreateProductDTO> products,
        String franchiseId
) {
}
