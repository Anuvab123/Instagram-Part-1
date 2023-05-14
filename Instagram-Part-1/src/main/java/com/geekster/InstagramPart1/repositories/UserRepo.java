package com.geekster.InstagramPart1.repositories;

import com.geekster.InstagramPart1.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
    User findFirstByEmail(String email);

    User findByUserId(Long userId);
}
