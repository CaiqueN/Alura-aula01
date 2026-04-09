package br.com.alura.trilha01.bytebank.aula03;

import java.util.Random;
import java.util.Scanner;

public class Adivinhacao {
    public static void executar() {
        Scanner scanner = new Scanner(System.in);
        int numeroGerado = new Random().nextInt(100);
        int tentativas = 0;
        int numeroDigitado = 0;

        while (tentativas < 5){
            System.out.println("Digite um número de 1 a 100");
            numeroDigitado = scanner.nextInt();
            tentativas++;

            if(numeroDigitado < numeroGerado){
                System.out.println("O número digitado é menor que numero gerado");
            } else if (numeroDigitado > numeroGerado) {
                System.out.println("O número digitado é maior que numero gerado");
            }
        }

        if(tentativas == 5 && numeroDigitado != numeroGerado){
            System.out.println("Você não conseguiu acertar o número em 05 tentativas. O número era: " + numeroGerado);
        }
    }

    public static void main(String[] args) {
        executar();
    }
}
