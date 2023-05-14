package com.geekster.InstagramPart1.controllers;

import com.geekster.InstagramPart1.dto.SignInInput;
import com.geekster.InstagramPart1.dto.SignInOutput;
import com.geekster.InstagramPart1.dto.SignUpInput;
import com.geekster.InstagramPart1.dto.SignUpOutput;
import com.geekster.InstagramPart1.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/signup")
    public SignUpOutput signup(@RequestBody SignUpInput signUpDto){
        return userService.signUp(signUpDto);
    }

    @PostMapping("/signin")
    public SignInOutput signup(@RequestBody SignInInput signInDto)
    {
        return userService.signIn(signInDto);
    }
}
