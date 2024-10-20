package com.hanghae.e_commerce.interfaces.api.payment.request;

import com.hanghae.e_commerce.interfaces.api.item.response.ItemResponse;
import lombok.Getter;

import java.util.List;

@Getter
public class OrderRequest {
    private Long userId;
    private Long orderId;

    public OrderRequest(Long userId, Long orderId) {
        this.userId = userId;
        this.orderId = orderId;
    }
}
