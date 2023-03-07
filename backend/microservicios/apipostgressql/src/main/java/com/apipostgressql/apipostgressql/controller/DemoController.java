package com.apipostgressql.apipostgressql.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/demo-controller")
public class DemoController {

    @PostMapping("/{nombre}")
    public ResponseEntity<String> hola(@PathVariable String nombre){
        return ResponseEntity.ok("Prueba de implementacion de token " + nombre);
    }
}
