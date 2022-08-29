package com.example.LojaAutomoveis.model;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConfigurarJDBC {
    private String driver, usuario, url, senha;
    private static final String CREATE = "create table if not exists veiculo(id int primary key auto_increment, marca varchar(50), modelo varchar(50), valor Float);";
    private Logger logger = Logger.getLogger(ConfigurarJDBC.class);

    public ConfigurarJDBC(String driver, String usuario, String url, String senha) {
        this.driver = driver;
        this.usuario = usuario;
        this.url = url;
        this.senha = senha;
    }

    public ConfigurarJDBC() {
        this.driver = "org.h2.Driver";
        this.url = "jdbc:h2:~/test";
        this.usuario = "sa";
        this.senha = "";
    }

    private String getDriver() {
        return driver;
    }

    private void setDriver(String driver) {
        this.driver = driver;
    }

    private String getUsuario() {
        return usuario;
    }

    private void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    private String getUrl() {
        return url;
    }

    private void setUrl(String url) {
        this.url = url;
    }

    private String getSenha() {
        return senha;
    }

    private void setSenha(String senha) {
        this.senha = senha;
    }

    public Connection conectarBanco()
    {
        Connection connection = null;
        Statement statement;

        try
        {
            logger.info("Conectando com o banco de dados");
            connection = DriverManager.getConnection(getUrl(), getUsuario(), getSenha());
            statement = connection.createStatement();
            statement.execute(CREATE);

        }catch(SQLException error)
        {
            logger.debug("Error ao conectar com o banco de dados");
            error.printStackTrace();
        }
        return connection;
    }
}
