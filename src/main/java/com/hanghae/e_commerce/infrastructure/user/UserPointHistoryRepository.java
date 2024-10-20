package com.hanghae.e_commerce.infrastructure.user;

import com.hanghae.e_commerce.domain.user.UserPoint;
import com.hanghae.e_commerce.domain.user.UserPointHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPointHistoryRepository extends JpaRepository<UserPointHistory, Long> {
}
