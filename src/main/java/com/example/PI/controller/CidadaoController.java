package com.example.PI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.PI.dto.Login;
import com.example.PI.model.Cidadao;
import com.example.PI.service.CidadaoService;


@CrossOrigin(origins = "*")

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

    //Login do cidadão
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Login request){
        try {
            Cidadao cidadao = service.login(request.getLogin(), request.getSenha());
            return ResponseEntity.ok(cidadao);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }



    //listar todos
    @GetMapping
   public List<Cidadao> listar(){
    return service.Listar();
   }

   @GetMapping("/{id}")
   public Cidadao buscar(@PathVariable String id){
    return service.buscarPorId(id);
   }

   @PutMapping("/{id}")
   public Cidadao atualizar(@PathVariable String id, @RequestBody Cidadao cidadao){
    return service.atualizar(id, cidadao);
   }

   @DeleteMapping("/{id}")
   public void deletar(@PathVariable String id){
    service.deletar(id);
   }

}
