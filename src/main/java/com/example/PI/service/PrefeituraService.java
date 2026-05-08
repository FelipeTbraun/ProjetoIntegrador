package com.example.PI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PI.model.Prefeitura;
import com.example.PI.repository.PrefeituraRepository;

@Service
public class PrefeituraService {
    

    @Autowired
    private PrefeituraRepository repository;

    public Prefeitura salvar(Prefeitura prefeitura){
        return repository.save(prefeitura);
    }

}
