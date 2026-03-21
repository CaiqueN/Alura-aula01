package Aula01.br.com.alura.bytebank;

import java.util.Scanner;

public class Saldo {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite um saldo: ");
        var saldo = leitura.nextDouble();
        double percentual = saldo * (10.0 / 100);
        var valorFinal = saldo + percentual;
        System.out.println("O saldo com reajuste de 10% é: " + valorFinal);
    }

}
