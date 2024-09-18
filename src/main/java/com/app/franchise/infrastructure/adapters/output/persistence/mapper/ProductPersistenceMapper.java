package com.app.franchise.infrastructure.adapters.output.persistence.mapper;
import com.app.franchise.domain.model.Product;
import com.app.franchise.infrastructure.adapters.output.persistence.entity.ProductEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductPersistenceMapper {

    ProductEntity fromProductToProductEntity(Product product);

    Product fromProductEntityToProduct(ProductEntity productEntity);

}
