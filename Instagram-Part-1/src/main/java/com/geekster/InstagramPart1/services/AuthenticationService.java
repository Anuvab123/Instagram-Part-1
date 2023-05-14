package com.geekster.InstagramPart1.services;

import com.geekster.InstagramPart1.models.AuthenticationToken;
import com.geekster.InstagramPart1.models.User;
import com.geekster.InstagramPart1.repositories.AuthenticationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    @Autowired
    AuthenticationRepo tokenRepo;
    public void saveToken(AuthenticationToken token) {
        tokenRepo.save(token);
    }

    public AuthenticationToken getToken(User user) {
        return  tokenRepo.findByUser(user);
    }
}
