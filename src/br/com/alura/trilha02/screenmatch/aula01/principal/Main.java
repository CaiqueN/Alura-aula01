package br.com.alura.trilha02.screenmatch.aula01.principal;

import br.com.alura.trilha02.screenmatch.aula01.desafio.principal.AlunoMain;
import br.com.alura.trilha02.screenmatch.aula01.desafio.principal.CalculadoraMain;
import br.com.alura.trilha02.screenmatch.aula01.desafio.principal.CarroMain;
import br.com.alura.trilha02.screenmatch.aula01.desafio.principal.MusicaMain;
import br.com.alura.trilha02.screenmatch.aula01.desafio.principal.Principal;
import br.com.alura.trilha02.screenmatch.aula01.principal.desafio.*;
import br.com.alura.trilha03.ContaMain;
import br.com.alura.trilha03.desafio.*;

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
        System.out.println("-- Desafio --");
        System.out.println("7 - Conta Bancária");
        System.out.println("8 - Idade Pessoa");
        System.out.println("9 - Aluno");
        System.out.println("10 - Produto com Desconto");
        System.out.println("11 - Livro");
        System.out.println("12 - Conta");
        System.out.println("13 - Carro modelo");
        System.out.println("14 - Animal");
        System.out.println("15 - Conta Bancária e Conta Corrente (herança)");
        System.out.println("16 - Numero primo");

        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1 -> PrincipalFilme.executar();
            case 2 -> Principal.executar();
            case 3 -> CalculadoraMain.executar();
            case 4 -> AlunoMain.executar();
            case 5 -> MusicaMain.executar();
            case 6 -> CarroMain.executar();
            case 7 -> ContaBancariaMain.executar();
            case 8 -> IdadePessoaMain.executar();
            case 9 -> AlunoDoisMain.executar();
            case 10 -> ProdutoMain.executar();
            case 11 -> LivroMain.executar();
            case 12 -> ContaMain.executar();
            case 13 -> CarroModelo.executar();
            case 14 -> AnimalMain.executar();
            case 15 -> TesteContaBancariaMain.executar();
            case 16 -> TesteNumeroPrimo.executar();

            default -> System.out.println("Opção inválida.");
        }

        scanner.close();
    }
}
