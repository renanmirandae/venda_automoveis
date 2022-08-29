package com.example.LojaAutomoveis.daoPattern;

import com.example.LojaAutomoveis.model.ConfigurarJDBC;
import com.example.LojaAutomoveis.model.Veiculo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

public class VeiculoDaoH2 implements IDao<Veiculo>{
    private ConfigurarJDBC configurarJDBC;
    private Logger logger = Logger.getLogger(String.valueOf(VeiculoDaoH2.class));

    public VeiculoDaoH2(ConfigurarJDBC configurarJDBC) {
        this.configurarJDBC = configurarJDBC;
    }

    @Override
    public Veiculo salvar(Veiculo veiculo) {
        Connection connection = null;
        Statement statement;
        String query = String.format("insert into veiculo(marca, modelo, valor) values('%s', '%s', '%s')", veiculo.getMarca(), veiculo.getModelo(), veiculo.getValor());

        try
        {
            logger.info("Salvando dados do veiculo no banco");
            connection = configurarJDBC.conectarBanco();
            statement = connection.createStatement();
            statement.executeUpdate(query, statement.RETURN_GENERATED_KEYS);
            ResultSet keys = statement.getGeneratedKeys();

            if(keys.next())
            {
                veiculo.setId(keys.getInt(1));
                connection.close();
                statement.close();
            }
        }catch(SQLException error)
        {
            error.printStackTrace();
            logger.info("Error em salvar veiculo");
        }

        return veiculo;
    }

    @Override
    public String buscar() {
        Connection connection = null;
        Statement statement;
        String query = "select * from veiculo";
        String listaVeiculos = " ";
        try
        {
            logger.info("Buscando veiculos no banco de dados");
            connection = configurarJDBC.conectarBanco();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next())
            {
                listaVeiculos = listaVeiculos + String.format("{id: '%s', marca: '%s', modelo: '%s', valor: '%s'}", resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getFloat(4));
            }

            connection.close();
            statement.close();
            resultSet.close();
        }catch(SQLException error)
        {
            logger.info("Erro em listar veiculos");
            error.printStackTrace();
        }

        return listaVeiculos;
    }
}
