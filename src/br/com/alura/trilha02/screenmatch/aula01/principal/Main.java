package br.com.alura.trilha02.screenmatch.aula01.principal;

import br.com.alura.trilha02.screenmatch.aula01.desafio.principal.AlunoMain;
import br.com.alura.trilha02.screenmatch.aula01.desafio.principal.CalculadoraMain;
import br.com.alura.trilha02.screenmatch.aula01.desafio.principal.CarroMain;
import br.com.alura.trilha02.screenmatch.aula01.desafio.principal.MusicaMain;
import br.com.alura.trilha02.screenmatch.aula01.desafio.principal.Principal;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Trilha 02 - Aula 01 ===");
        System.out.println("Escolha um exercício:");
        System.out.println("1 - Filme");
        System.out.println("2 - Pessoa (saudação)");
        System.out.println("3 - Calculadora (dobro)");
        System.out.println("4 - Aluno");
        System.out.println("5 - Música");
        System.out.println("6 - Carro");

        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1 -> PrincipalFilme.executar();
            case 2 -> Principal.executar();
            case 3 -> CalculadoraMain.executar();
            case 4 -> AlunoMain.executar();
            case 5 -> MusicaMain.executar();
            case 6 -> CarroMain.executar();
            default -> System.out.println("Opção inválida.");
        }

        scanner.close();
    }
}
