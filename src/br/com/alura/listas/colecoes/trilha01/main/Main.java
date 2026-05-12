package br.com.alura.listas.colecoes.trilha01.main;

import br.com.alura.listas.colecoes.trilha01.produtoperecivel.TesteProdutoPerecivel;
import br.com.alura.listas.colecoes.trilha01.arraylist.TesteArrayListStrings;
import br.com.alura.listas.colecoes.trilha01.heranca.Cachorro;
import br.com.alura.listas.colecoes.trilha01.precomedio.TesteProduto2;
import br.com.alura.listas.colecoes.trilha01.forma.TestarForma;
import br.com.alura.listas.colecoes.trilha01.contabancaria.TestarContaBancaria;
import br.com.alura.listas.colecoes.trilha01.aula.TesteListaExemplo;
import br.com.alura.listas.colecoes.trilha01.pessoa.Pessoa;
import br.com.alura.listas.colecoes.trilha01.produto.TesteProduto;
import br.com.alura.listas.colecoes.trilha01.desafio.Ordenacao;
import br.com.alura.listas.colecoes.trilha01.desafio.UsoPolimorfismo;
import br.com.alura.listas.colecoes.trilha01.hashmap.ExemploHashMap;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Trilha 01 - Java Listas e Coleções ===");
        System.out.println("Escolha um exercício:");
        System.out.println("-- Aula 01 --");
        System.out.println("1 - Array");
        System.out.println("2 - atividade Pessoa");
        System.out.println("3 - atividade Produto");
        System.out.println("4 - atividade Produto Perecivel");
        System.out.println("5 - atividade - ArrayListStrings");
        System.out.println("6 - atividade - Cachorro");
        System.out.println("7 - atividade - Preço médio de produtos");
        System.out.println("8 - atividade - Forma");
        System.out.println("9 - atividade - Conta Bancária");
        System.out.println("10 - Exemplo HashMap ");
        System.out.println("11 - Ordenação ");
        System.out.println("12 - Uso Polimorfismo");
        System.out.println("13 - Projeto final");

        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1  -> TesteListaExemplo.executar();
            case 2 -> Pessoa.executar();
            case 3 -> TesteProduto.executar();
            case 4 -> TesteProdutoPerecivel.executar();
            case 5 -> TesteArrayListStrings.executar();
            case 6 -> Cachorro.executar();
            case 7 -> TesteProduto2.executar();
            case 8 -> TestarForma.executar();
            case 9 -> TestarContaBancaria.executar();
            case 10 -> ExemploHashMap.executar();
            case 11 -> Ordenacao.executar();
            case 12 -> UsoPolimorfismo.executar();

            default -> System.out.println("Opção inválida.");
        }
    }
}

