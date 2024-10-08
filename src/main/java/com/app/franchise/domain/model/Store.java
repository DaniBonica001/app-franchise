package com.app.franchise.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Store {

    private String storeId;
    private String name;

    @ReadOnlyProperty
    @DocumentReference(lookup="{'stores':?#{#self._id} }")
    private List<Product> products;
    private String franchiseId;
}
