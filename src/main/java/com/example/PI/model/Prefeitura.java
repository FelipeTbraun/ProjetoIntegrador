package com.example.PI.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "prefeituras")

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
