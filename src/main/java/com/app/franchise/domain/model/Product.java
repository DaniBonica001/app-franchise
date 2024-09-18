package com.app.franchise.domain.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {

    private String productId;
    private String name;
    private int stock;
    private String storeId;
}
