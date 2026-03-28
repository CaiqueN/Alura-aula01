package java_trilha_01.aula03.desafio_aula_03;

import java.util.Scanner;

public class NumeroMaior {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o número 1");
        int numero_1 = scanner.nextInt();
        System.out.println("Digite o número 2");
        int numero_2 = scanner.nextInt();

        if (numero_1 == numero_2){
            System.out.println("Os dois números são iguais");
        }else if (numero_1 > numero_2){
            System.out.println("Número 1 é maior que número 2 ");
        } else {
            System.out.println("Número 1 é menor que número 2");
        }
    }
}
