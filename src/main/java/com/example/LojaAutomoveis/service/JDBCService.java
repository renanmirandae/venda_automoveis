package com.example.LojaAutomoveis.service;

import com.example.LojaAutomoveis.model.ConfigurarJDBC;

import java.sql.Connection;
public class JDBCService {
    private ConfigurarJDBC configurarJDBC;

    public Connection conectarBanco()
    {
        return configurarJDBC.conectarBanco();
    }
}
