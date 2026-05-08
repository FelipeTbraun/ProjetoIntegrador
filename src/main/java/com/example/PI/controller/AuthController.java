package com.example.PI.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.PI.dto.Login;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {
    
    private final String ADMIN_EMAIL = "admin";
    private final String ADMIN_PASSWORD = "senha123";

    @PostMapping("/adminlogin")
    public ResponseEntity<String> loginAdmin(
        @RequestBody Login request
    ){
        
        if(request.getLogin().equals(ADMIN_EMAIL)
        &&
        request.getSenha().equals(ADMIN_PASSWORD)){
            return ResponseEntity.ok("Login realizado");
        }
            return ResponseEntity.badRequest().body("Login ou senha incorretos");
        
    }

}