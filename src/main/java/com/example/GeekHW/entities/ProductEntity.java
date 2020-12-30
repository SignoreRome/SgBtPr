package com.example.GeekHW.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductEntity {
    private int id;
    private String title;
    private int cost;

    public ProductEntity() {
    }

    public ProductEntity(int id, String title, int cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }
}
