package com.example.LojaAutomoveis.daoPattern;

import com.example.LojaAutomoveis.model.Veiculo;
import com.example.LojaAutomoveis.service.JDBCService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

public class VeiculoDaoH2 implements IDao<Veiculo>{
    private JDBCService jdbcService;
    private Logger logger = Logger.getLogger(String.valueOf(VeiculoDaoH2.class));

    @Override
    public Veiculo salvar(Veiculo veiculo) {
        Connection connection = null;
        Statement statement;
        String query = String.format("insert into veiculo(marca, modelo, valor) values('%s', '%s', '%s')", veiculo.getMarca(), veiculo.getModelo(), veiculo.getValor());

        try
        {
            logger.info("Salvando dados do veiculo no banco");
            connection = jdbcService.conectarBanco();
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
    public Veiculo buscar(Veiculo veiculo) {
        return null;
    }
}
