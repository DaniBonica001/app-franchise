package com.app.franchise.infrastructure.adapters.input.rest.mapper;

import com.app.franchise.domain.model.Product;
import com.app.franchise.infrastructure.adapters.input.rest.dto.request.CreateProductDTO;
import com.app.franchise.infrastructure.adapters.input.rest.dto.response.CreateProductResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductRestMapper {

    Product fromCreateProductDTOToProduct(CreateProductDTO createProductDTO);

    CreateProductResponseDTO fromProductToCreateProductResponseDTO(Product product);
}
