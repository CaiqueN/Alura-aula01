package br.com.alura.trilha03;

public class ContaMain {
    public static void executar(){
        ContaPoupanca conta = new ContaPoupanca();
        conta.setTitular("Caique Nunes");
        conta.depositar(1600);
        conta.setTaxaJuros(0.05);
        conta.calcularJuros();
        conta.sacar(1000);

        System.out.println("Nome do titular: " + conta.getTitular());
        System.out.println("Taxa de juros: " + conta.getTaxaJuros());
        System.out.println("Saldo atual " + conta.getSaldo());
    }
}
