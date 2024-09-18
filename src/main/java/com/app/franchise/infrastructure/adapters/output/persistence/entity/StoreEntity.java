package com.app.franchise.infrastructure.adapters.output.persistence.entity;

import com.app.franchise.domain.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "stores")
public class StoreEntity {

    @Id
    private String storeId;
    private String name;
    private List<Product> products;
    private String franchiseId;
}
