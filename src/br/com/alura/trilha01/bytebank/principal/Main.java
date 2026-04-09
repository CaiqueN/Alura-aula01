package br.com.alura.trilha01.bytebank.principal;

import br.com.alura.trilha01.bytebank.aula01.Principal;
import br.com.alura.trilha01.bytebank.aula01.exercicio.Estudos;
import br.com.alura.trilha01.bytebank.aula01.exercicio.Perfil;
import br.com.alura.trilha01.bytebank.aula01.exercicio.Soma;
import br.com.alura.trilha01.bytebank.aula01.exercicio.Subtracao;
import br.com.alura.trilha01.bytebank.aula02.Main;
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
            case 1  -> Principal.main(new String[]{});
            case 2  -> Estudos.main(new String[]{});
            case 3  -> Perfil.main(new String[]{});
            case 4  -> Soma.main(new String[]{});
            case 5  -> Subtracao.main(new String[]{});
            case 6  -> Main.main(new String[]{});
            case 7  -> Dolares.main(new String[]{});
            case 8  -> DesafioPratico.main(new String[]{});
            case 9  -> Adivinhacao.main(new String[]{});
            case 10 -> Tabuada.main(new String[]{});
            case 11 -> Fatorial.main(new String[]{});
            case 12 -> Conta.main(new String[]{});
            default -> System.out.println("Opção inválida.");
        }
    }
}
