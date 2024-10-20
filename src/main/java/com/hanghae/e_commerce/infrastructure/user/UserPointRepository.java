package com.hanghae.e_commerce.infrastructure.user;

import com.hanghae.e_commerce.domain.user.UserPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserPointRepository extends JpaRepository<UserPoint, Long> {

    // 커스텀해서 만들거라면?
    // save, xxxxSave

//    @Query("SELECT up FROM UserPoint up WHERE up.userID = :userId")
//    UserPoint getUserPoint(@Param("userId") Long userId);
}

