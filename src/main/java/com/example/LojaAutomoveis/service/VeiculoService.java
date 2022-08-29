package com.example.LojaAutomoveis.service;

import com.example.LojaAutomoveis.daoPattern.IDao;
import com.example.LojaAutomoveis.model.Veiculo;

public class VeiculoService {
    private IDao<Veiculo> veiculoDao;

    public VeiculoService(IDao<Veiculo> veiculoDao) {
        this.veiculoDao = veiculoDao;
    }

    public Veiculo salvar(Veiculo veiculo)
    {
        return veiculoDao.salvar(veiculo);
    }

    public Veiculo buscar(Veiculo veiculo)
    {
        return this.veiculoDao.buscar(veiculo);
    }

    public Veiculo registrarVeiculo(String marca, String modelo, Float valor)
    {
        Veiculo veiculo = new Veiculo(marca, modelo, valor);
        return veiculo;
    }
}
