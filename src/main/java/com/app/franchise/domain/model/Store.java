package com.app.franchise.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "stores")
public class Store {

    private Integer store_id;
    private String name;

    @ReadOnlyProperty
    @DocumentReference(lookup="{'stores':?#{#self._id} }")
    private List<Product> products;
}
