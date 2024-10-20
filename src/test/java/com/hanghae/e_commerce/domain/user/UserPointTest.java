package com.hanghae.e_commerce.domain.user;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class UserPointTest {

    @Test
    void 유저_포인트_충전() {
        // given
        Long amount = 10000L;
        UserPoint userPoint = UserPoint.of(0L);

        // when
        userPoint.chargeBalance(amount);

        // then
        assertEquals(amount, userPoint.getBalance()); // 1번방법: jupiter 패키지 사용
//        assertThat(userPoint.getBalance()).isEqualTo(amount); // 2번방법: assertj 패키지 사용
    }

    @Test
    void 유저가_포인트를_0원이하_충전을_했을_경우에_테스트가_실패해야한다() {
        // given
        UserPoint userPoint = UserPoint.of(0L);
        Long amount = -3000L;

        // when
        userPoint.chargeBalance(amount);

        // then

    }

    @Test
    void 유저가_MAX_10만원_이상으로_충전할_경우_테스트_실패() {

    }

    @Test
    void 유저가_결제했을때_잔액이_부족하면_결제실패() {

    }
}