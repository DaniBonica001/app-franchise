package com.app.franchise.infrastructure.adapters.input.rest.dto.response;

import lombok.Builder;

@Builder
public record CreateProductResponseDTO(
        String productId,
        String name,
        int stock,
        String storeId
) {
}
