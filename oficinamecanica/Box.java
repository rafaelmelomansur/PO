/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oficinamecanica;

import java.util.ArrayList;

/**
 *
 * @author 1525535
 */
public class Box {

private int numero;
private String tipoServico;
private int capacidadeMaxima;
private String localizacao;
private Mecanico mecanicoResponsavel;
private ArrayList<OrdemServico> ordens;

public Box(int numero, String tipoServico,
int capacidadeMaxima, String localizacao) {

this.numero = numero;
this.tipoServico = tipoServico;
this.capacidadeMaxima = capacidadeMaxima;
this.localizacao = localizacao;
this.mecanicoResponsavel = null;
this.ordens = new ArrayList<>();
}

    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * @return the tipoServico
     */
    public String getTipoServico() {
        return tipoServico;
    }

    /**
     * @param tipoServico the tipoServico to set
     */
    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
    }

    /**
     * @return the capacidadeMaxima
     */
    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    /**
     * @param capacidadeMaxima the capacidadeMaxima to set
     */
    public void setCapacidadeMaxima(int capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
    }

    /**
     * @return the localizacao
     */
    public String getLocalizacao() {
        return localizacao;
    }

    /**
     * @param localizacao the localizacao to set
     */
    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    /**
     * @return the mecanicoResponsavel
     */
    public Mecanico getMecanicoResponsavel() {
        return mecanicoResponsavel;
    }

    /**
     * @param mecanicoResponsavel the mecanicoResponsavel to set
     */
    public void setMecanicoResponsavel(Mecanico mecanicoResponsavel) {
        this.mecanicoResponsavel = mecanicoResponsavel;
    }

    /**
     * @return the ordens
     */
    public ArrayList<OrdemServico> getOrdens() {
        return ordens;
    }

    /**
     * @param ordens the ordens to set
     */
    public void setOrdens(ArrayList<OrdemServico> ordens) {
        this.ordens = ordens;
    }

public boolean adicionarOrdem(OrdemServico ordem) {

if (    getOrdens().size() >= getCapacidadeMaxima()) {
System.out.println("O box atingiu sua capacidade maxima.");
return false;
}

if (ordem.getServico() == null) {
System.out.println("A ordem nao possui servico.");
return false;
}

if (!ordem.getServico().getCategoria().equalsIgnoreCase(tipoServico)) {
System.out.println("O tipo de servico da ordem nao e permitido neste box.");
return false;
}

        getOrdens().add(ordem);
ordem.setBox(this);
ordem.setStatus("em execucao");

System.out.println("Ordem atribuida ao box com sucesso.");

return true;
}

public void removerOrdem(OrdemServico ordem) {
        getOrdens().remove(ordem);
}

public void exibirOrdens() {

System.out.println("\n===== ORDENS DO BOX " + getNumero() + " =====");

if (    getOrdens().isEmpty()) {
System.out.println("Nao existem ordens neste box.");
System.out.println("Total de ordens: 0");
return;
}

for (OrdemServico ordem : getOrdens()) {

System.out.println("-----------------------------");
System.out.println("Codigo: " + ordem.getCodigo());
System.out.println("Cliente: " + ordem.getNomeCliente());
System.out.println("Veiculo: " + ordem.getModeloVeiculo());
System.out.println("Placa: " + ordem.getPlacaVeiculo());
System.out.println("Status: " + ordem.getStatus());
}

System.out.println("-----------------------------");
System.out.println("Total de ordens: " + getOrdens().size());
}

public int contarOrdens() {
return  getOrdens().size();
}
}