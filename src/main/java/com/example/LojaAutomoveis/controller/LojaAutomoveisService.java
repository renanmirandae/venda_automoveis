package com.example.LojaAutomoveis.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LojaAutomoveisService {

    @GetMapping("/listaveiculos")
    public String listaVeiculos()
    {
        return "Lista de veiculos";
    }
}
