package com.hanghae.e_commerce.domain.user.service;

import com.hanghae.e_commerce.domain.user.UserPoint;
import com.hanghae.e_commerce.domain.user.UserPointHistory;
import com.hanghae.e_commerce.domain.user.service.constant.UserPointTransactionType;
import com.hanghae.e_commerce.infrastructure.user.UserPointHistoryRepository;
import com.hanghae.e_commerce.infrastructure.user.UserPointRepository;
import com.hanghae.e_commerce.interfaces.api.user.request.UserPointCharge;
import com.hanghae.e_commerce.interfaces.api.user.response.UserPointResponse;
import com.hanghae.e_commerce.usecase.user.UserPointUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserPointService implements UserPointUseCase {

    private final UserPointRepository userPointRepository;
    private final UserPointHistoryRepository userPointHistoryRepository;

    @Transactional // 트랜잭션 범위 -> 이 서비스 호출되는 시점부터 디비 커넥션 열어줘! 그리고 이거 호출 끝나면 디비 커넥션 닫아
    @Override
    public void chargeUserPoint(UserPointCharge userPointCharge) {
        // 1. 회원을 가져온다. (있는지 없는지) -> user Entity -> userPoint
        // 1. 스킵한다 ?  왜 ? 김현철이라는 애가 이미 이사이트에 로그인해서 충전페이지에 들어왔을거라는 가정하에.
        // find 찾다. (못찾았으면 null)
        // get 가져와.
//        userPointRepository.getUserPoint(userPointCharge.getId());

        // 1. 충전할 UserPoint 객체를 가져온다.
        UserPoint userPoint = userPointRepository.findById(userPointCharge.getId())
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾지 못했습니다.")); //.get() 사용 시, npe가 발생

        // 2. 충전을 한다.
        userPoint.chargeBalance(userPointCharge.getAmount());

        // 3. 충전 히스토리에 저장한다.
        userPointHistoryRepository.save(UserPointHistory.of(userPointCharge.getId(), userPointCharge.getAmount(), UserPointTransactionType.CHARGE));
    }

    @Override
    public UserPointResponse getUserPoint(Long userId) {
        // 0. 회원을 가져온다. or 회원이 유효한지 확인한다. (있는지 없는지)

        // 1. 유저포인트 객체를 가져온다.
        UserPoint userPoint = userPointRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾지 못했습니다."));

        // 2. 조회한 UserPoint 정보를 response 에 감싸 반환한다.
        return new UserPointResponse(userPoint.getId(), userPoint.getBalance());
    }
}
