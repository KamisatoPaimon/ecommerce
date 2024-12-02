package com.example.BE_Ecommerce.Controller;


import com.example.BE_Ecommerce.Dto.AuthRequest;
import com.example.BE_Ecommerce.Dto.AuthResponse;
import com.example.BE_Ecommerce.Entity.User;
import com.example.BE_Ecommerce.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/")
public class AuthController {

    @Autowired
    private AuthService authService;
    @PostMapping("login")
    public AuthResponse login(@RequestBody AuthRequest authRequest) {
        return authService.login(authRequest);
    }

    @PostMapping("register")
    public AuthResponse registerNewUser(@RequestBody User user) {
        return authService.register(user);
    }
}
