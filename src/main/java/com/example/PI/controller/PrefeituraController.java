package com.example.PI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.PI.model.Prefeitura;
import com.example.PI.service.PrefeituraService;

@Controller
@RestController("/prefeitura")
public class PrefeituraController {
    
@Autowired
private PrefeituraService service;

@PostMapping
public Prefeitura salvar(@RequestBody Prefeitura prefeitura){
    return service.salvar(prefeitura);
}

}
