package br.com.alura.trilha02.screenmatch.aula01.principal.desafio;

public class ContaBancariaMain {
    public static void executar() {
        ContaBancaria conta = new ContaBancaria();

        conta.setNumeroConta(1234);
        conta.setTitular("Italo");
        conta.depositar(500);


        System.out.println("Número da conta: " + conta.getNumeroConta());
        System.out.println("Saldo da conta: " + conta.getSaldo());
        System.out.println("Nome do titular: " + conta.getTitular());

        System.out.println("Novo saldo: " + conta.getSaldo());

    }
}
