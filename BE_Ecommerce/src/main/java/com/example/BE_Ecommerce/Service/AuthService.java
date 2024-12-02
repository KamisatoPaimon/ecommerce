package com.example.BE_Ecommerce.Service;


import com.example.BE_Ecommerce.Dto.AuthRequest;
import com.example.BE_Ecommerce.Dto.AuthResponse;
import com.example.BE_Ecommerce.Entity.User;
import com.example.BE_Ecommerce.Repository.UserRepository;
import com.example.BE_Ecommerce.Security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Autowired
    private JwtTokenProvider jwtTokenProvider;


    public AuthResponse register(User newUser) {
        User user = userRepository.findByUserName(newUser.getUserName());
        if (user != null) {
            return new AuthResponse("400", "Registration Failed Tài khoản đã tồn tại!", null, 0);
        }
        newUser.setUserPassword(passwordEncoder.encode(newUser.getUserPassword()));
        userRepository.save(newUser);
        return new AuthResponse("Register Success", "Registration successful!", null, 0);
    }

    public AuthResponse login(AuthRequest authRequest) {
        User user = userRepository.findByUserName(authRequest.getUsername());
        if (user == null) {
            return new AuthResponse("404", "User not found!", null, 0);
        }

        boolean passwordMatches = passwordEncoder.matches(authRequest.getPassword(), user.getUserPassword());
        if (!passwordMatches) {
            return new AuthResponse("401", "Invalid credentials!", null, 0); // Mật khẩu sai
        }

        return new AuthResponse("201", "Login success!", jwtTokenProvider.createToken(user.getUserName()), 3600000);
    }
}
