package com.example.PI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.PI.model.Formulario;
import com.example.PI.service.FormularioService;

@RestController
@RequestMapping("/form")
public class FormularioController {
    
    @Autowired
    private FormularioService service;

    //Criar formulario
    @PostMapping()
    public Formulario criar(@RequestBody Formulario formulario){
        return service.criar(formulario);
    }
    
    //listar todos(somente prefeitura,p vou mudar depois)
    @GetMapping("/admin")
    public List<Formulario> listar(){
        return service.listar();
    }
    
    //buscar por id(somente prefeitura, vou mudar depois)
    @GetMapping("/admin/{id}")
    public Formulario buscar(@PathVariable Long id){
        return service.buscarPorId(id);
    }

}
