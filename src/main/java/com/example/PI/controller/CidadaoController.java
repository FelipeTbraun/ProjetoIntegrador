package com.example.PI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.PI.model.Cidadao;
import com.example.PI.service.CidadaoService;




@RestController
@RequestMapping("/cidadao")
public class CidadaoController {
    
    @Autowired
    private CidadaoService service;

    //Cadastro do cidadão
    @PostMapping("/cadastro")
    public Cidadao cadastrar(@RequestBody Cidadao cidadao){
        return service.cadastrar(cidadao);
    }

  
    
    //listar todos
    @GetMapping
   public List<Cidadao> listar(){
    return service.Listar();
   }
    
   @GetMapping("/{id}")
   public Cidadao buscar(@PathVariable Long id){
    return service.buscarPorId(id);
   }
   
   @PutMapping("/{id}")
   public Cidadao atualizar(@PathVariable Long id, @RequestBody Cidadao cidadao){
    return service.atualizar(id, cidadao);
   }
   
   @DeleteMapping("/{id}")
   public void deletar(@PathVariable Long id){
    service.deletar(id);
   }

}
