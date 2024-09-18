package com.app.franchise.infrastructure.adapters.output.persistence.mapper;

import com.app.franchise.domain.model.Store;
import com.app.franchise.infrastructure.adapters.output.persistence.entity.StoreEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StorePersistenceMapper {

    StoreEntity fromStoreToStoreEntity(Store store);

    Store fromStoreEntityToStore(StoreEntity storeEntity);
}
