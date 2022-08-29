package com.example.LojaAutomoveis.controller;

import com.example.LojaAutomoveis.daoPattern.VeiculoDaoH2;
import com.example.LojaAutomoveis.model.ConfigurarJDBC;
import com.example.LojaAutomoveis.service.VeiculoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LojaAutomoveisService {
    @RequestMapping("/listaveiculos")
    public String listaVeiculos()
    {
        VeiculoService veiculoService = new VeiculoService(new VeiculoDaoH2(new ConfigurarJDBC()));;

        return veiculoService.buscar();
    }
}
