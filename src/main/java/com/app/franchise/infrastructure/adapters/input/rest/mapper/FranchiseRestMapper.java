package com.app.franchise.infrastructure.adapters.input.rest.mapper;

import com.app.franchise.domain.model.Franchise;
import com.app.franchise.infrastructure.adapters.input.rest.dto.request.CreateFranchiseDTO;
import com.app.franchise.infrastructure.adapters.input.rest.dto.response.CreateFranchiseResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface FranchiseRestMapper {

    Franchise fromCreateFranchiseDTOToFranchise(CreateFranchiseDTO createFranchiseDTO);

    CreateFranchiseResponseDTO fromFranchiseToCreateFranchiseResponseDTO(Franchise franchise);
}
