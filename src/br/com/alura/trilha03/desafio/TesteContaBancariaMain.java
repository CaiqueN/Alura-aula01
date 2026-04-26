package br.com.alura.trilha03.desafio;

public class TesteContaBancariaMain {
    public static void executar() {
        ContaBancaria conta = new ContaBancaria();
        conta.depositar(2000);
        conta.consultarSaldo();

        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.depositar(200);
        contaCorrente.cobrarTarifa();
        contaCorrente.consultarSaldo();
        contaCorrente.sacar(150);
        contaCorrente.consultarSaldo();
    }
}
