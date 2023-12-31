package com.example.QuizApplication.auth;

import com.example.QuizApplication.config.JwtService;
import com.example.QuizApplication.repository.UserRepository;
import com.example.QuizApplication.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService service;
    private final AuthenticationManager authenticationManager;
    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
          .userName(request.getUserName())
          .email(request.getEmail())
          .password(passwordEncoder.encode(request.getPassword()))
          .build();

        user = userRepository.save(user);
        var jwtToken = service.generateToken(user);
        return AuthenticationResponse.builder()
                .user(user)
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = service.generateToken(user);
        return AuthenticationResponse.builder()
                .user(user)
                .token(jwtToken)
                .build();
    }

}
