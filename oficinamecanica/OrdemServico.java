/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oficinamecanica;

/**
 *
 * @author 1525535
 */
public class OrdemServico {

private int codigo;
private String nomeCliente;
private String modeloVeiculo;
private String placaVeiculo;
private String data;
private String status;
private double valorEstimado;
private Servico servico;
private Box box;

public OrdemServico(int codigo, String nomeCliente, String modeloVeiculo, String placaVeiculo, String data, String status, double valorEstimado, Servico servico) {

this.codigo = codigo;
this.nomeCliente = nomeCliente;
this.modeloVeiculo = modeloVeiculo;
this.placaVeiculo = placaVeiculo;
this.data = data;
this.status = status;
this.valorEstimado = valorEstimado;
this.servico = servico;
this.box = null;
}



    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nomeCliente
     */
    public String getNomeCliente() {
        return nomeCliente;
    }

    /**
     * @param nomeCliente the nomeCliente to set
     */
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    /**
     * @return the modeloVeiculo
     */
    public String getModeloVeiculo() {
        return modeloVeiculo;
    }

    /**
     * @param modeloVeiculo the modeloVeiculo to set
     */
    public void setModeloVeiculo(String modeloVeiculo) {
        this.modeloVeiculo = modeloVeiculo;
    }

    /**
     * @return the placaVeiculo
     */
    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    /**
     * @param placaVeiculo the placaVeiculo to set
     */
    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }

    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the valorEstimado
     */
    public double getValorEstimado() {
        return valorEstimado;
    }

    /**
     * @param valorEstimado the valorEstimado to set
     */
    public void setValorEstimado(double valorEstimado) {
        this.valorEstimado = valorEstimado;
    }

    /**
     * @return the servico
     */
    public Servico getServico() {
        return servico;
    }

    /**
     * @param servico the servico to set
     */
    public void setServico(Servico servico) {
        this.servico = servico;
    }

    /**
     * @return the box
     */
    public Box getBox() {
        return box;
    }

    /**
     * @param box the box to set
     */
    public void setBox(Box box) {
        this.box = box;
    }

public void exibirDetalhes() {

System.out.println("\n===== DETALHES DA ORDEM =====");
System.out.println("Codigo: " + getCodigo());
System.out.println("Cliente: " + getNomeCliente());
System.out.println("Modelo: " + getModeloVeiculo());
System.out.println("Placa: " + getPlacaVeiculo());
System.out.println("Data: " + getData());
System.out.println("Status: " + getStatus());
System.out.println("Valor estimado: R$ " + getValorEstimado());

if (    getServico() != null) {
System.out.println("\n--- SERVICO ---");
System.out.println("Nome: " + getServico().getNome());
System.out.println("Tempo estimado: " + getServico().getTempoEstimado() + " minutos");
System.out.println("Valor: R$ " + getServico().getValor());
System.out.println("Categoria: " + getServico().getCategoria());
}

if (    getBox() != null) {
System.out.println("\n--- BOX ---");
System.out.println("Numero: " + getBox().getNumero());
System.out.println("Localizacao: " + getBox().getLocalizacao());
System.out.println("Tipo de servico: " + getBox().getTipoServico());

if (        getBox().getMecanicoResponsavel() != null) {
System.out.println("Mecanico: "
+               getBox().getMecanicoResponsavel().getNome());
}
} else {
System.out.println("\nBox: Nenhum box atribuido.");
}
}
}

   