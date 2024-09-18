package com.app.franchise.infrastructure.adapters.output.persistence.entity;

import com.app.franchise.domain.model.Store;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;


import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "franchises")
public class FranchiseEntity {
    @Id
    private String franchiseId;
    private String name;
    private List<Store> stores;
}
