package com.example.PI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PI.model.Formulario;
import com.example.PI.repository.FormularioRepository;

@Service
public class FormularioService {

    @Autowired
    private FormularioRepository repository;

    public Formulario criar(Formulario f){
        f.setStatus("Aberta");
        return repository.save(f);
    }
    public List<Formulario> listar(){
        return repository.findAll();
    }

    public Formulario buscarPorId( Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Formulario não encontrado"));
    }

    public void deletar( Long id){
        if(!repository.existsById(id)){
            throw new RuntimeException("Formulário não encontrado");
        }
       repository.deleteById(id);
    }
}
