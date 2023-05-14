package com.geekster.InstagramPart1.repositories;

import com.geekster.InstagramPart1.models.AuthenticationToken;
import com.geekster.InstagramPart1.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthenticationRepo extends JpaRepository<AuthenticationToken,Long> {
    AuthenticationToken findByUser(User user);
}
