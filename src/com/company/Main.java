package com.company;

import models.Produto;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

Scanner scanner = new Scanner(System.in);

System.out.print("qual a descrição que você desejar dar ao novo produto:");
String descricao = scanner.nextLine();

System.out.print("qual o ID você desejar dar ao novo produto: ");
int id = scanner.nextInt();

        Produto novoProduto = new Produto();
//novoProduto.setId(id);
//novoProduto.setDescricao(descricao);

System.out.println("Produto criado com sucesso:");
        System.out.println("____ID" + novoProduto.getId());
        System.out.println("____Descrição;" + novoProduto.getDescricao());

    }
}
