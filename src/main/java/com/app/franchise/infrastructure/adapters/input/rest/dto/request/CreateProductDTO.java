package com.app.franchise.infrastructure.adapters.input.rest.dto.request;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record CreateProductDTO(


        @NotBlank(message = "Name is required")
        String name,

        @NotNull
        @Min(value=0, message = "Stock must be greater than or equal to 0")
        int stock

) {
}
