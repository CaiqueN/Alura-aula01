package br.com.alura.listas.colecoes.trilha01.main;

import br.com.alura.listas.colecoes.trilha01.ListaExemplo;
import br.com.alura.listas.colecoes.trilha01.atividade.Pessoa;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Trilha 01 - Java Listas e Coleções ===");
        System.out.println("Escolha um exercício:");
        System.out.println("-- Aula 01 --");
        System.out.println("1 -Array");
        System.out.println("2 - atividade Pessoa");


        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1  -> ListaExemplo.executar();
            case 2 -> Pessoa.executar();

            default -> System.out.println("Opção inválida.");
        }
    }
}

