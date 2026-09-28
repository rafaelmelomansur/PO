/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oficinamecanica;

/**
 *
 * @author 1525535
 */
public class Servico {

private String nome;
private int tempoEstimado;
private double valor;
private String categoria;

public Servico(String nome, int tempoEstimado, double valor, String categoria) {
this.nome = nome;
this.tempoEstimado = tempoEstimado;
this.valor = valor;
this.categoria = categoria;
}

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the tempoEstimado
     */
    public int getTempoEstimado() {
        return tempoEstimado;
    }

    /**
     * @param tempoEstimado the tempoEstimado to set
     */
    public void setTempoEstimado(int tempoEstimado) {
        this.tempoEstimado = tempoEstimado;
    }

    /**
     * @return the valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * @return the categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
