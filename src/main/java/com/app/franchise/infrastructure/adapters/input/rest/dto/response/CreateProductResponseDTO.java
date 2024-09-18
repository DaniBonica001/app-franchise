package com.app.franchise.infrastructure.adapters.input.rest.dto.response;

import lombok.Builder;

@Builder
public record CreateProductResponseDTO(
        Integer productId,
        String name,
        int stock
) {
}
