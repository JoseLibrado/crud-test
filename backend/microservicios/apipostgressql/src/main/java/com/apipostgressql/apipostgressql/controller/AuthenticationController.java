package com.apipostgressql.apipostgressql.controller;

import com.apipostgressql.apipostgressql.pojo.AuthenticationRequest;
import com.apipostgressql.apipostgressql.pojo.AuthenticationResponse;
import com.apipostgressql.apipostgressql.pojo.RegisterRequest;
import com.apipostgressql.apipostgressql.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5500/")
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ){
        return ResponseEntity.ok(service.register(request));
    }


    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ){
        return ResponseEntity.ok(service.authenticate(request));
    }

}
