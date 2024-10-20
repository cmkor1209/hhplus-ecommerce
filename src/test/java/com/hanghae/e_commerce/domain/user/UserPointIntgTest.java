package com.hanghae.e_commerce.domain.user;

import com.hanghae.e_commerce.domain.user.service.UserPointService;
import com.hanghae.e_commerce.infrastructure.user.UserPointHistoryRepository;
import com.hanghae.e_commerce.infrastructure.user.UserPointRepository;
import com.hanghae.e_commerce.interfaces.api.user.request.UserPointCharge;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SpringBootTest
public class UserPointIntgTest {

    @Autowired
    private UserPointService userPointService;

    @Autowired
    private UserPointRepository userPointRepository;

    @Autowired
    private UserPointHistoryRepository userPointHistoryRepository;

    @ Test// 디비커넥션 어디서 열릴까?
    void 유저_포인트_충전_성공() {
        // given UserPoint 임시 데이터 저장. // 디비커넥션열어서 얘부터 저장하고 시작해야 돼.?
        UserPoint userPoint = userPointRepository.save(UserPoint.of(0L));

        // when
        userPointService.chargeUserPoint(new UserPointCharge(userPoint.getId(), 1000L));

        // then
        Assertions.assertThat(userPoint.getBalance()).isEqualTo(1000);
    }

    @Test
    void 유저_포인트_충전금액_오차로인한_실패() {

    }
}
