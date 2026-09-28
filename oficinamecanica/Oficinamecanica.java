/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.oficinamecanica;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 1525535
 */
public class Oficinamecanica  {

static Scanner scanner = new Scanner(System.in);

static ArrayList<Mecanico> mecanicos = new ArrayList<>();
static ArrayList<Box> boxes = new ArrayList<>();
static ArrayList<OrdemServico> ordens = new ArrayList<>();

public static void main(String[] args) {

criarDadosIniciais();

int opcao;

do {
System.out.println("\n===== OFICINA MECANICA =====");
System.out.println("1 - Cadastrar ordem");
System.out.println("2 - Associar mecanico ao box");
System.out.println("3 - Atribuir ordem ao box");
System.out.println("4 - Ver ordens do box");
System.out.println("5 - Ver ordens finalizadas por box");
System.out.println("6 - Buscar ordens por status");
System.out.println("7 - Ver detalhes de uma ordem");
System.out.println("8 - Finalizar ordem");
System.out.println("0 - Sair");
System.out.print("Opcao: ");

opcao = scanner.nextInt();
scanner.nextLine();

switch (opcao) {
case 1:
cadastrarOrdem();
break;
case 2:
associarMecanico();
break;
case 3:
atribuirOrdem();
break;
case 4:
verOrdensBox();
break;
case 5:
verFinalizadas();
break;
case 6:
buscarStatus();
break;
case 7:
detalhesOrdem();
break;
case 8:
finalizarOrdem();
break;
case 0:
System.out.println("Programa encerrado.");
break;
default:
System.out.println("Opcao invalida.");
}

} while (opcao != 0);
}

public static void criarDadosIniciais() {

Mecanico m1 = new Mecanico(
"Carlos", "111", "Motor", "9999-1111");

Mecanico m2 = new Mecanico(
"Joao", "222", "Freios", "9999-2222");

Mecanico m3 = new Mecanico(
"Pedro", "333", "Eletrica", "9999-3333");

mecanicos.add(m1);
mecanicos.add(m2);
mecanicos.add(m3);

boxes.add(new Box(1, "Motor", 3, "Area A"));
boxes.add(new Box(2, "Freios", 2, "Area B"));
boxes.add(new Box(3, "Eletrica", 2, "Area C"));
}

public static void cadastrarOrdem() {

System.out.print("Codigo: ");
int codigo = scanner.nextInt();
scanner.nextLine();

if (buscarOrdem(codigo) != null) {
System.out.println("Codigo ja cadastrado.");
return;
}

System.out.print("Nome do cliente: ");
String cliente = scanner.nextLine();

System.out.print("Modelo do veiculo: ");
String modelo = scanner.nextLine();

System.out.print("Placa: ");
String placa = scanner.nextLine();

System.out.print("Data: ");
String data = scanner.nextLine();

System.out.print("Nome do servico: ");
String nome = scanner.nextLine();

System.out.print("Tempo estimado: ");
int tempo = scanner.nextInt();

System.out.print("Valor do servico: ");
double valor = scanner.nextDouble();
scanner.nextLine();

System.out.print("Categoria: ");
String categoria = scanner.nextLine();

System.out.print("Valor estimado da ordem: ");
double valorEstimado = scanner.nextDouble();
scanner.nextLine();

Servico servico = new Servico(
nome, tempo, valor, categoria);

OrdemServico ordem = new OrdemServico(
codigo, cliente, modelo, placa, data,
"aberta", valorEstimado, servico);

ordens.add(ordem);

System.out.println("Ordem cadastrada.");
}

public static void associarMecanico() {

System.out.print("CPF do mecanico: ");
String cpf = scanner.nextLine();

Mecanico mecanico = buscarMecanico(cpf);

if (mecanico == null) {
System.out.println("Mecanico nao encontrado.");
return;
}

if (mecanico.getBoxResponsavel() != null) {
System.out.println("Mecanico ja possui um box.");
return;
}

System.out.print("Numero do box: ");
int numero = scanner.nextInt();
scanner.nextLine();

Box box = buscarBox(numero);

if (box == null) {
System.out.println("Box nao encontrado.");
return;
}

if (box.getMecanicoResponsavel() != null) {
System.out.println("Box ja possui mecanico.");
return;
}

mecanico.setBoxResponsavel(box);
box.setMecanicoResponsavel(mecanico);

System.out.println("Mecanico associado.");
}

public static void atribuirOrdem() {

System.out.print("Codigo da ordem: ");
int codigo = scanner.nextInt();
scanner.nextLine();

OrdemServico ordem = buscarOrdem(codigo);

if (ordem == null) {
System.out.println("Ordem nao encontrada.");
return;
}

if (!ordem.getStatus().equalsIgnoreCase("aberta")) {
System.out.println("A ordem nao esta aberta.");
return;
}

System.out.print("Numero do box: ");
int numero = scanner.nextInt();
scanner.nextLine();

Box box = buscarBox(numero);

if (box == null) {
System.out.println("Box nao encontrado.");
return;
}

if (box.getMecanicoResponsavel() == null) {
System.out.println("O box nao possui mecanico.");
return;
}

box.adicionarOrdem(ordem);
}

public static void verOrdensBox() {

System.out.print("Numero do box: ");
int numero = scanner.nextInt();
scanner.nextLine();

Box box = buscarBox(numero);

if (box == null) {
System.out.println("Box nao encontrado.");
return;
}

box.exibirOrdens();
}

public static void verFinalizadas() {

for (Box box : boxes) {

int total = 0;

for (OrdemServico ordem : ordens) {
if (ordem.getStatus().equalsIgnoreCase("finalizada")
&& ordem.getBox() == box) {
total++;
}
}

System.out.println(
"Box " + box.getNumero() + ": " + total);
}
}

public static void buscarStatus() {

System.out.print("Status: ");
String status = scanner.nextLine();

boolean encontrou = false;

for (OrdemServico ordem : ordens) {

if (ordem.getStatus().equalsIgnoreCase(status)) {

encontrou = true;

System.out.println("\nCodigo: " + ordem.getCodigo());
System.out.println("Cliente: " + ordem.getNomeCliente());
System.out.println("Veiculo: " + ordem.getModeloVeiculo());
System.out.println("Placa: " + ordem.getPlacaVeiculo());
System.out.println("Status: " + ordem.getStatus());

if (ordem.getBox() != null) {
System.out.println("Box: " + ordem.getBox().getNumero());

System.out.println("Mecanico: " + ordem.getBox().getMecanicoResponsavel().getNome());
}
}
}

if (!encontrou) {
System.out.println("Nenhuma ordem encontrada.");
}
}

public static void detalhesOrdem() {

System.out.print("Codigo da ordem: ");
int codigo = scanner.nextInt();
scanner.nextLine();

OrdemServico ordem = buscarOrdem(codigo);

if (ordem == null) {
System.out.println("Ordem nao encontrada.");
} else {
ordem.exibirDetalhes();
}
}

public static void finalizarOrdem() {

System.out.print("Codigo da ordem: ");
int codigo = scanner.nextInt();
scanner.nextLine();

OrdemServico ordem = buscarOrdem(codigo);

if (ordem == null) {
System.out.println("Ordem nao encontrada.");
return;
}

if (!ordem.getStatus().equalsIgnoreCase("em execucao")) {
System.out.println("A ordem nao esta em execucao.");
return;
}

Box box = ordem.getBox();

ordem.setStatus("finalizada");

if (box != null) {
box.removerOrdem(ordem);
}

System.out.println("Ordem finalizada.");
}

public static Mecanico buscarMecanico(String cpf) {

for (Mecanico mecanico : mecanicos) {
if (mecanico.getCpf().equals(cpf)) {
return mecanico;
}
}

return null;
}

public static Box buscarBox(int numero) {

for (Box box : boxes) {
if (box.getNumero() == numero) {
return box;
}
}

return null;
}

public static OrdemServico buscarOrdem(int codigo) {

for (OrdemServico ordem : ordens) {
if (ordem.getCodigo() == codigo) {
return ordem;
}
}

return null;
}
}
