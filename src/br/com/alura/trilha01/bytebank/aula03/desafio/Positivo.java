package br.com.alura.trilha01.bytebank.aula03.desafio;

import java.util.Scanner;

public class Positivo {
    public static void main(String[] args) {
        System.out.println("Digite um numero");
        Scanner scanner = new Scanner(System.in);
        int numero = scanner.nextInt();
        if (numero >= 7){
            System.out.println("Número positivo");
        }else {
            System.out.println("Número negativo");
        }
    }
}
