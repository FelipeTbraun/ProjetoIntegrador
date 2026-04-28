package com.example.PI.service;

import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private final String EMAIL = "admin@prefeitura.com";
    private final String SENHA = "senha123";

    public boolean login(String email, String senha){
        return EMAIL.equals(email) && SENHA.equals(senha);
    }
}
