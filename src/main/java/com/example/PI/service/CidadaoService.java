package com.example.PI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PI.model.Cidadao;
import com.example.PI.repository.CidadaoRepository;

@Service
public class CidadaoService {

    @Autowired
    private CidadaoRepository repository;

    public Cidadao cadastrar(Cidadao c){
        if(repository.findByEmail(c.getEmail()) != null){
            throw new RuntimeException("Email ja cadastrado");
        }
        if(repository.findByCpf(c.getCpf()) !=null ){
            throw new RuntimeException("CPF já cadastrado");
        }
         return repository.save(c);
    }

    public List<Cidadao> Listar(){
        return repository.findAll();
    }
    public Cidadao buscarPorId(Long id){
        return repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Cidadão não encontrado"));
    }

    public Cidadao login (String email, String senha){

        Cidadao c = repository.findByEmail(email);

        if(c == null || !c.getSenha().equals(senha)){
            throw new RuntimeException("Email ou senha inválidos");
        }
        return c;
    }
}
