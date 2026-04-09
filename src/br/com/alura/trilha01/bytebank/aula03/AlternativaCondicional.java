package br.com.alura.trilha01.bytebank.aula03;

import java.util.Scanner;

public class AlternativaCondicional {
    public static void main(String[] args) {
        System.out.println("Digite digitar o número da semana: ");
        Scanner scanner = new Scanner(System.in);
        int dia = scanner.nextInt();

        String nomeDia = "";

        switch (dia){
            case 1:
                nomeDia = "Domingo";
                break;

            case 2:
                nomeDia = "Segunda-feira";
                break;
            case 3:
                nomeDia = "Terça-feira";
                break;
            case 4:
                nomeDia = "Quarta-feira";
                break;
            case 5:
                nomeDia = "Quinta-feira";
                break;
            case 6:
                nomeDia = "Sexta-feira";
                break;
            case 7:
                nomeDia = "Sábado";
            default:
                System.out.println("Valor inválido");
                break;
        }

        System.out.println("O dia " + dia + " é " + nomeDia);
    }
}
