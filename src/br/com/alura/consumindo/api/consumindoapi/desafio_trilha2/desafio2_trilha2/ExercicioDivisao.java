package br.com.alura.consumindo.api.consumindoapi.desafio_trilha2.desafio2_trilha2;

import java.util.Scanner;

public class ExercicioDivisao {
    public static void executar() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o número 1");
        int numero_1 = scanner.nextInt();

        System.out.println("Informe o número 2");
        int numero_2 = scanner.nextInt();

        try {
            int resultado = numero_1 / numero_2;
            System.out.println("Resultado da divisão: " + resultado);
        } catch (ArithmeticException e) {
            System.out.println("Erro: Divisão por zero não permitida.");
        }
    }
}
