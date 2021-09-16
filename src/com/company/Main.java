package com.company;

import db.EstoquesDB;
import db.ProdutosDB;
import db.ProdutosDB;
import db.UsuariosDB;
import models.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static java.util.Scanner.*;

public class Main {

    static ProdutosDB produtosDB= new ProdutosDB();
    static UsuariosDB usuariosDB = new UsuariosDB();
    static EstoquesDB estoquesDB = new EstoquesDB();

    public static void main(String[] args) throws Exception {

        System.out.println("______PEDIDO DE VENDAS_____");

        int option;
        do {
            System.out.println(" 1 -CADASTRAR PRODUTO");
            System.out.println("2 -LISTAR PRODUTO CADASTRADO");
            System.out.println("3 - CADASTRAR USUÁRIO ADMINISTRADOR");
            System.out.println("4 - CADASTRAR USUÁRIO CLIENTE");
            System.out.println("5 - LISTAR TODOS USUÁRIOS CADASTRADOS");
            System.out.println("6 - CADASTRAR NOVO ESTOQUE DE PRODUTO");
            System.out.println("0 - SAIR");


            Scanner scanner = new Scanner(System.in);
            System.out.print("QUAL OPERAÇÃO VOCÊ DESEJA REALIZAR:");
            option = scanner.nextInt();

         process(option);
        } while (option != 0);

    }
    public static void process(int option) throws Exception {
        switch (option) {
            case 1: {

                Scanner scanner = new Scanner(System.in);

                System.out.print("qual a descrição que você desejar dar ao novo produto:");
                String descricao = scanner.nextLine();

                System.out.print("qual o ID você desejar dar ao novo produto: ");
                int id = scanner.nextInt();

                System.out.print(" Qual é o preço: ");
                double preco = scanner.nextDouble();
                System.out.print(" Qual a data de validade: ");
                String dataString = scanner.next();
                Date dataValidade = new SimpleDateFormat("dd/MM/yyyy").parse(dataString);

                Produto novoProduto = new Produto(id, descricao, preco, dataValidade);

                produtosDB.addNovoProduto(novoProduto);
                break;

            }

            //System.out.println("Produto criado com sucesso:");
            //System.out.println("____ID" + novoProduto.getId());
            //System.out.println("____Descrição;" + novoProduto.getDescricao());
            //System.out.println("____Preço;" + novoProduto.getPreco());
            //System.out.println("____Data de Validade;" + novoProduto.getDataValidade());
            //System.out.println("==========================================================");

            case 2: {
                List<Produto> listaDeProdutos = produtosDB.getProdutosList();

                for (Produto produto : listaDeProdutos) {

                    System.out.println("---->> ID" + produto.getId());
                    System.out.println("---->> Descrição: " + produto.getDescricao());
                    System.out.println("---->> Preço :" + produto.getPreco());
                    System.out.println("---->> Data de Validade 1:" + produto.getDataValidade());
                    System.out.println("==========================================================");


                    break;
                }

            }
            case 3: {
                Scanner scanner = new Scanner(System.in);
                System.out.print("QUAL O NOME DO ADMINISTRADOR : ");
                String nome = scanner.nextLine();

                Admin novoAdmin = new Admin(nome);
                usuariosDB.addNovoUsuario(novoAdmin);

                break;
            }

            case 4: {
                Scanner scanner = new Scanner(System.in);
                System.out.print("QUAL O NOME DO USUÁRIO CLIENTE : ");
                String nome = scanner.nextLine();

                Cliente novoCliente = new Cliente(nome);
                usuariosDB.addNovoUsuario(novoCliente);

                break;
            }

            case 5: {
                for (Usuario usuario : usuariosDB.getUsuarioList()) {
                    System.out.println("==========================================================");
                    System.out.println("==============LISTANDO USUÁRIOS CADASTRADOS:==============");
                    System.out.println("==========================================================");
                    System.out.println("ID :" + usuario.getId());
                    System.out.println("NOME :" + usuario.getNome());
                    System.out.println("TIPO :" + usuario.getTipoUsuario());
                    System.out.println("==========================================================");
                }

                break;
            }
            case 6: {
                Scanner scanner = new Scanner(System.in);
                System.out.println("==========================================================");
                System.out.println("==============CADASTRANDO ESTOQUE DE PRODUTO:==============");
                System.out.println("==========================================================");
                System.out.print("QUAL O IDENTIFICADOR DO ESTOQUE: ");
                String id = scanner.next();
                System.out.print("QUAL O PRODUTO QUE SERÁ ADICIONADO NO ESTOQUE: ");
                int produtoId = scanner.nextInt();
                Produto produto = produtosDB.getProdutoPorID(produtoId);
                System.out.println("PRODUTO ID :" + produto.getId());
                System.out.println("PRODUTO DESCRIÇÃO :" + produto.getDescricao());
                System.out.println("TIPO :" + produto.getDataValidade());
                System.out.print("QUAL A QUANTIDADE DE PRODUTOS A SER ADICIONADO NO ESTOQUE: ");
                int quantidade = scanner.nextInt();
                Estoque novoEstoque = new Estoque(id,produto,quantidade);
                estoquesDB.addNovoEstoque(novoEstoque);
                break;
            }


        }

    }
    }

