package com.example.LojaAutomoveis.daoPattern;

public interface IDao <T> {
    public T salvar(T t);
    public String buscar();
}
