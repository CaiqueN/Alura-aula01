package br.com.alura.consumindo.api.consumindoapi;

import br.com.alura.consumindo.api.consumindoapi.desafio_trilha2.EditoraLivro;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Consumindo API ===");
        System.out.println("Escolha um exercício:");
        System.out.println("1 - Busca de filme (OMDB)");
        System.out.println("2 - Busca editora e livro");


        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1 -> ApiGetMain.executar();
            case 2 -> EditoraLivro.executar();

            default -> System.out.println("Opção inválida.");
        }
    }
}
