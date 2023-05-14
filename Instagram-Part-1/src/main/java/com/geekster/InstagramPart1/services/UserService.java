package com.geekster.InstagramPart1.services;

import com.geekster.InstagramPart1.dto.SignInInput;
import com.geekster.InstagramPart1.dto.SignInOutput;
import com.geekster.InstagramPart1.dto.SignUpInput;
import com.geekster.InstagramPart1.dto.SignUpOutput;
import com.geekster.InstagramPart1.models.AuthenticationToken;
import com.geekster.InstagramPart1.models.User;
import com.geekster.InstagramPart1.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    @Autowired
    AuthenticationService tokenService;
    public SignUpOutput signUp(SignUpInput signUpDto) {

        User user = userRepo.findFirstByEmail(signUpDto.getEmail());

        if(user != null){
            throw new IllegalStateException("User already exists!!!!...sign in instead");
        }

        user = new User(signUpDto.getFirstName(),signUpDto.getLastName(),signUpDto.getAge(),signUpDto.getEmail(),signUpDto.getPhoneNumber());

        userRepo.save(user);

        AuthenticationToken token = new AuthenticationToken(user);

        tokenService.saveToken(token);

        return new SignUpOutput("User registered","User created successfully");
    }

    public SignInOutput signIn(SignInInput signInDto) {

        User user = userRepo.findFirstByEmail(signInDto.getUserEmail());

        if(user==null){
            throw new IllegalStateException("User invalid!!!!...sign up instead");
        }

        AuthenticationToken authToken = tokenService.getToken(user);

        return new SignInOutput("Authentication Successfull !!!",authToken.getToken());
    }
}
