package br.com.alura.trilha02.screenmatch.aula01.principal.desafio;

public class ContaBancariaMain {
    public static void executar() {
        ContaBancaria conta = new ContaBancaria();

        conta.setNumeroConta(1234);
        conta.setSaldo(100);
        conta.setTitular("Italo");

        System.out.println("Número da conta: " + conta.getNumeroConta());
        System.out.println("Saldo da conta: " + conta.getSaldo());
        System.out.println("Nome do titular: " + conta.getTitular());

        conta.setSaldo(1600);
        System.out.println("Novo saldo: " + conta.getSaldo());

    }
}
