package br.com.alura.trilha01.bytebank.aula01;

import java.util.Scanner;

public class Saldo {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite um saldo: ");
        var saldo = leitura.nextDouble();
        double percentual = saldo * (10.0 / 100);
        var valorFinal = saldo + percentual;
        System.out.println("O saldo com reajuste de 10% é: " + valorFinal);

        double media = (8.1 / 9.1);
        System.out.println(media);
    }

}
