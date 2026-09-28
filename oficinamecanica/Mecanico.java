/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oficinamecanica;

/**
 *
 * @author 1525535
 */
public class Mecanico {

private String nome;
private String cpf;
private String especialidade;
private String telefone;
private Box boxResponsavel;

public Mecanico(String nome, String cpf, String especialidade, String telefone) {
this.nome = nome;
this.cpf = cpf;
this.especialidade = especialidade;
this.telefone = telefone;
this.boxResponsavel = null;
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
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the especialidade
     */
    public String getEspecialidade() {
        return especialidade;
    }

    /**
     * @param especialidade the especialidade to set
     */
    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the boxResponsavel
     */
    public Box getBoxResponsavel() {
        return boxResponsavel;
    }

    /**
     * @param boxResponsavel the boxResponsavel to set
     */
    public void setBoxResponsavel(Box boxResponsavel) {
        this.boxResponsavel = boxResponsavel;
    }

}
