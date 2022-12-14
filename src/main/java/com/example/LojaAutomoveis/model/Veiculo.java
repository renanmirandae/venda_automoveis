package com.example.LojaAutomoveis.model;

public class Veiculo {
    private String marca, modelo;
    private int id;
    private Float valor;

    public Veiculo(String marca, String modelo, Float valor) {
        this.marca = marca;
        this.modelo = modelo;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", id=" + id +
                ", valor=" + valor +
                '}';
    }
}
