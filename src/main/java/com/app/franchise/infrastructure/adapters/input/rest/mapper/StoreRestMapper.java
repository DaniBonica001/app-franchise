package com.app.franchise.infrastructure.adapters.input.rest.mapper;

import com.app.franchise.domain.model.Store;
import com.app.franchise.infrastructure.adapters.input.rest.dto.request.CreateStoreDTO;
import com.app.franchise.infrastructure.adapters.input.rest.dto.response.CreateStoreResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StoreRestMapper {

    Store fromCreateStoreDTOToStore(CreateStoreDTO createStoreDTO);

    CreateStoreResponseDTO fromStoreToCreateStoreResponseDTO(Store store);

}
