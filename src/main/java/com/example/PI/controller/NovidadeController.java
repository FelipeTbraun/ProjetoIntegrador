package com.example.PI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.PI.model.Novidade;
import com.example.PI.service.NovidadeService;

@RestController
@RequestMapping("/novidade")
@CrossOrigin(origins = "*")
public class NovidadeController {

    @Autowired
    private NovidadeService service;

    // criar novidade (prefeitura)
    @PostMapping
    public Novidade criar(@RequestBody Novidade novidade) {
        return service.criar(novidade);
    }

    // listar novidades (público, aparece na Home)
    @GetMapping
    public List<Novidade> listar() {
        return service.listar();
    }

    // excluir novidade (prefeitura)
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable String id) {
        service.deletar(id);
    }
}
