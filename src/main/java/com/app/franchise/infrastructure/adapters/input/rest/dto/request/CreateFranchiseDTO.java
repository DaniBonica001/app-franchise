package com.app.franchise.infrastructure.adapters.input.rest.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record CreateFranchiseDTO(

        @NotBlank(message = "Name is required")
        String name
) {
}
