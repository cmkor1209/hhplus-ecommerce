package com.hanghae.e_commerce.interfaces.api.user.request;

import lombok.Getter;

@Getter
public class UserPointCharge {
    private Long id;
    private Long amount;

    public UserPointCharge(Long id, Long amount) {
        this.id = id;
        this.amount = amount;
    }
}
