package com.hanghae.e_commerce.interfaces.api.user;

import com.hanghae.e_commerce.domain.user.UserPoint;
import com.hanghae.e_commerce.interfaces.api.user.request.UserPointCharge;
import com.hanghae.e_commerce.interfaces.api.user.response.UserPointResponse;
import com.hanghae.e_commerce.usecase.user.UserPointUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserPointUseCase userPointUseCase;

    /**
     * 1. 잔액 조회
     *
     * @RequestParam(쿼리파라미터) localhost:8080/api/members/balance?id=1
     * @PathVariable(경로변수) localhost:8080/api/members/1/balance
     */
    @GetMapping("/api/users/{userId}/point")
    public ResponseEntity<UserPointResponse> getMemberBalance(@PathVariable Long userId) {
        return ResponseEntity.ok().body(userPointUseCase.getUserPoint(userId));
    }

    @PostMapping("/api/users/point")
    public ResponseEntity<Integer> chargeMemberBalance(@RequestBody UserPointCharge request) {
        userPointUseCase.chargeUserPoint(request);
        return ResponseEntity.ok().build();
    }
    /**
     * GET-조회 @RequestParam
     *
     * POST-삽입/삭제
     *
     * PATCH-수정
     *
     * DELETE-삭제
     *
     * RESTful 하게...
     *
     * GET /member : 멤버를 조회한다.
     * POST /member : 멤버를 추가한다.
     * PATCH /member : 멤버를 수정한다.
     * DELETE /member
     *
     * url -> 1 요청 4개를 감당할 수 있지.
     */

    /**
     * {
     *     "id": 1,
     *     "balance": 2000
     * }
     *
     */
}

