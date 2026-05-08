package com.example.PI.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;



@Entity

public class Prefeitura {
    
    
    @Id
    private String id;
    private String login;
    private String senha;
    
    public Prefeitura(){
        this.login ="LoginAdmin";
        this.senha = "Admin123";
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
