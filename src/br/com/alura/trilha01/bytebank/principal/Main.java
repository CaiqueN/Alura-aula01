package br.com.alura.trilha01.bytebank.principal;

import br.com.alura.trilha01.bytebank.aula01.Principal;
import br.com.alura.trilha01.bytebank.aula01.exercicio.Estudos;
import br.com.alura.trilha01.bytebank.aula01.exercicio.Perfil;
import br.com.alura.trilha01.bytebank.aula01.exercicio.Soma;
import br.com.alura.trilha01.bytebank.aula01.exercicio.Subtracao;
import br.com.alura.trilha01.bytebank.aula02.desafio.DesafioPratico;
import br.com.alura.trilha01.bytebank.aula02.desafio.Dolares;
import br.com.alura.trilha01.bytebank.aula03.Adivinhacao;
import br.com.alura.trilha01.bytebank.aula03.desafio.Fatorial;
import br.com.alura.trilha01.bytebank.aula03.desafio.Tabuada;
import br.com.alura.trilha01.bytebank.aula04.Conta;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Trilha 01 - Java ByteBank ===");
        System.out.println("Escolha um exercício:");
        System.out.println("-- Aula 01 --");
        System.out.println("1  - ByteBank (Funcionario)");
        System.out.println("2  - Estudos (conceitos Java)");
        System.out.println("3  - Perfil");
        System.out.println("4  - Soma");
        System.out.println("5  - Subtração");
        System.out.println("-- Aula 02 --");
        System.out.println("6  - ScreenMatch (variáveis e tipos)");
        System.out.println("7  - Conversão Dólares");
        System.out.println("8  - Desafio Média");
        System.out.println("-- Aula 03 --");
        System.out.println("9  - Adivinhação");
        System.out.println("10 - Tabuada");
        System.out.println("11 - Fatorial");
        System.out.println("-- Aula 04 --");
        System.out.println("12 - Conta Bancária");

        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1  -> Principal.executar();
            case 2  -> Estudos.executar();
            case 3  -> Perfil.executar();
            case 4  -> Soma.executar();
            case 5  -> Subtracao.executar();
            case 6  -> br.com.alura.trilha01.bytebank.aula02.Main.executar();
            case 7  -> Dolares.executar();
            case 8  -> DesafioPratico.executar();
            case 9  -> Adivinhacao.executar();
            case 10 -> Tabuada.executar();
            case 11 -> Fatorial.executar();
            case 12 -> Conta.executar();
            default -> System.out.println("Opção inválida.");
        }
    }
}
