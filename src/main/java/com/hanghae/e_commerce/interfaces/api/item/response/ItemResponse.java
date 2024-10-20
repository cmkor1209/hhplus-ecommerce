package com.hanghae.e_commerce.interfaces.api.item.response;

import lombok.Getter;

@Getter
public class ItemResponse {
    private Long id;
    private String name;
    private int price;
    private int stock;

    public ItemResponse(Long id, String name, int price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
}
