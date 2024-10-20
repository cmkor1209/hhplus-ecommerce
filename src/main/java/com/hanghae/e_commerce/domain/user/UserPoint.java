package com.hanghae.e_commerce.domain.user;

import com.hanghae.e_commerce.domain.user.exception.OutOfBalanceException;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class UserPoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_point_id")
    private Long id;

    private Long balance; // 0 -> 10000 -> update query

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private UserPoint(Long balance) {
        this.balance = balance;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public static UserPoint of(Long balance) {
        return new UserPoint(balance);
    }

    // 1차캐시, 영속성 컨텍스트, 더티체킹
    public void chargeBalance(Long amount) {
        this.balance += amount;
        this.updatedAt = LocalDateTime.now();
    }

    public void useBalance(Long amount) {
        this.balance -= amount;
        this.updatedAt = LocalDateTime.now();
    }
}
