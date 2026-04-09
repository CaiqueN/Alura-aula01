package br.com.alura.trilha01.bytebank.aula04;

import java.util.Scanner;

public class Conta {
    public static void executar() {
        String nome = "Pedro Laranjeira";
        String conta = "corrente";
        double saldo = 1599.99;
        int opcao = 0;

        System.out.println("=======================");
        System.out.println("Nome do cliente" + nome);
        System.out.println("Tipo de conta" + conta);
        System.out.println("Saldo em conta" + saldo);
        System.out.println("=======================");

        String menu = """
                 ** Digite sua opção **
                     1 - Consultar saldo
                     2 - Transferir valor
                     3 - Receber valor
                     4 - Sair
                 """;

        Scanner scanner = new Scanner(System.in);
        while (opcao !=4){
            System.out.println(menu);
            opcao = scanner.nextInt();

            if(opcao == 1){
                System.out.println(" O saldo atualizado é: " + saldo);
            } else if (opcao == 2) {
                System.out.println("Por gentileza digite o saldo para transferência?");
                double valor = scanner.nextInt();
                if (valor > saldo){
                    System.out.println("Não há saldo em conta para essa transferência");
                }else {
                    saldo -= valor;
                    System.out.println("Novo saldo: " + saldo);
                    }

                } else if (opcao ==3) {
                System.out.println("Saldo recebido");
                double valor = scanner.nextDouble();
                saldo += valor;
                System.out.println("Novo saldo" + saldo);
            } else if (opcao !=4) {
                System.out.println("Essa opção é invalida,por favor digite uma opção");
            }
          }
        }

    public static void main(String[] args) {
        executar();
    }
}

