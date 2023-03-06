package com.apipostgressql.apipostgressql.service;

import com.apipostgressql.apipostgressql.entity.Role;
import com.apipostgressql.apipostgressql.entity.WebserviceEntity;
import com.apipostgressql.apipostgressql.pojo.AuthenticationRequest;
import com.apipostgressql.apipostgressql.pojo.AuthenticationResponse;
import com.apipostgressql.apipostgressql.pojo.RegisterRequest;
import com.apipostgressql.apipostgressql.repository.WebserviceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final PasswordEncoder passwordEncoder;
    private final WebserviceRepository repository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    public AuthenticationResponse register(RegisterRequest request) {
        var user = WebserviceEntity.builder()
                .name(request.getName())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getName(),
                        request.getPassword()
                )
        );
        var user = repository.findByName(request.getName())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
