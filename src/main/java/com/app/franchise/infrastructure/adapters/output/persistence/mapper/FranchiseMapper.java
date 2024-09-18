package com.app.franchise.infrastructure.adapters.output.persistence.mapper;

import com.app.franchise.domain.model.Franchise;
import com.app.franchise.infrastructure.adapters.output.persistence.entity.FranchiseEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FranchiseMapper {

    FranchiseEntity fromFranchiseToFranchiseEntity(Franchise franchise);

    Franchise fromFranchiseEntityToFranchise(FranchiseEntity franchiseEntity);
}
