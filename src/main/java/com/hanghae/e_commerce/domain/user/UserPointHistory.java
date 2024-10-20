package com.hanghae.e_commerce.domain.user;

import com.hanghae.e_commerce.domain.user.service.constant.UserPointTransactionType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class UserPointHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_point_history_id")
    private Long id;

    private Long pointId;

    private Long amount;

    private UserPointTransactionType userPointTransactionType;

    private LocalDateTime createdAt;

    private UserPointHistory(Long pointId, Long amount, UserPointTransactionType userPointTransactionType) {
        this.pointId = pointId;
        this.amount = amount;
        this.userPointTransactionType = userPointTransactionType;
        this.createdAt = LocalDateTime.now();
    }

    public static UserPointHistory of(Long pointId, Long amount, UserPointTransactionType userPointTransactionType) {
        return new UserPointHistory(pointId, amount, userPointTransactionType);
    }
}
