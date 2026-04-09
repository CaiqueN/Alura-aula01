package br.com.alura.trilha01.bytebank.aula03.desafio;

import java.util.Scanner;

public class Tabuada {
    public static void executar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite um número");
        int numero = scanner.nextInt();

        System.out.println("Tabuada do número" + numero);
        for (int i = 1; i < 10 ; i++) {
            System.out.println("x" + i + "=" + (numero * i) );
        }
    }

    public static void main(String[] args) {
        executar();
    }
}
