package com.hanghae.e_commerce.interfaces.api.user.response;

import lombok.Getter;

@Getter
public class UserPointResponse {

    private Long id; // userPointId

    private Long balance;

    public UserPointResponse(Long id, Long balance) {
        this.id = id;
        this.balance = balance;
    }
}
