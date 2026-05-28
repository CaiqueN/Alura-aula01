package br.com.alura.consumindo.api.consumindoapi;

import br.com.alura.consumindo.api.consumindoapi.desafio_trilha2.EditoraLivro;
import br.com.alura.consumindo.api.consumindoapi.desafio_trilha2.desafio2_trilha2.ConsultaGitHub;
import br.com.alura.consumindo.api.consumindoapi.desafio_trilha2.desafio2_trilha2.ExercicioDivisao;
import br.com.alura.consumindo.api.consumindoapi.desafio_trilha2.desafio2_trilha2.ExercicioSenha;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Consumindo API ===");
        System.out.println("Escolha um exercício:");
        System.out.println("1 - Busca de filme (OMDB)");
        System.out.println("2 - Busca editora e livro");
        System.out.println("3- Busca exercicio de divisao");
        System.out.println("4 - Busca senha exception");
        System.out.println("5 - Consulta GitHub");


        try {
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> ApiGetMain.executar();
                case 2 -> EditoraLivro.executar();
                case 3 -> ExercicioDivisao.executar();
                case 4 -> ExercicioSenha.executar();
                case 5 -> ConsultaGitHub.executar();

                default -> System.out.println("Opção inválida.");
            }
        } catch (java.util.InputMismatchException e) {
            System.out.println("Digite apenas números inteiros.");
        }
    }
}
