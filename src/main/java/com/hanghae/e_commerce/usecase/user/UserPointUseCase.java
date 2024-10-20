package com.hanghae.e_commerce.usecase.user;

import com.hanghae.e_commerce.interfaces.api.user.request.UserPointCharge;
import com.hanghae.e_commerce.interfaces.api.user.response.UserPointResponse;

public interface UserPointUseCase {
    void chargeUserPoint(UserPointCharge userPointCharge);

    UserPointResponse getUserPoint(Long userId);
}