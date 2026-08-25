package com.example.PI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.PI.dto.StatusUpdate;
import com.example.PI.model.Formulario;
import com.example.PI.service.FormularioService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/form")
public class FormularioController {

    @Autowired
    private FormularioService service;

    // Criar formulario
    @PostMapping()
    public Formulario criar(@RequestBody Formulario formulario) {
        return service.criar(formulario);
    }

    // listar todos(somente prefeitura,p vou mudar depois)
    @GetMapping("/admin")
    public List<Formulario> listar() {
        return service.listar();
    }

    // buscar por id(somente prefeitura, vou mudar depois)
    @GetMapping("/admin/{id}")
    public Formulario buscar(@PathVariable String id) {
        return service.buscarPorId(id);
    }

    // listar formularios enviados por um cidadão específico
    @GetMapping("/cidadao/{cidadaoId}")
    public List<Formulario> listarPorCidadao(@PathVariable String cidadaoId) {
        return service.listarPorCidadao(cidadaoId);
    }

    // atualizar status e resposta (somente prefeitura)
    @PutMapping("/status/{id}")
    public ResponseEntity<?> atualizarStatus(@PathVariable String id, @RequestBody StatusUpdate statusUpdate) {
        try {
            Formulario atualizado = service.atualizarStatus(id, statusUpdate.getStatus(), statusUpdate.getResposta());
            return ResponseEntity.ok(atualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/excluir/{id}")
    public void deletar(@PathVariable String id) {
        service.deletar(id);
    }

}
