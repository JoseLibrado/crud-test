package com.apipostgressql.apipostgressql.controller;

import ch.qos.logback.classic.Logger;
import com.apipostgressql.apipostgressql.pojo.AuthenticationRequest;
import com.apipostgressql.apipostgressql.pojo.AuthenticationResponse;
import com.apipostgressql.apipostgressql.pojo.RegisterRequest;
import com.apipostgressql.apipostgressql.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final Log LOGGER = LogFactory.getLog(AuthenticationService.class);
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
        LOGGER.info("Cuerpo de peticion: " + request.toString());
        return ResponseEntity.ok(service.authenticate(request));
    }

}
