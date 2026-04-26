package br.com.alura.trilha03.desafio;

public class ContaCorrente extends ContaBancaria {
    private double tarifa;

    public void cobrarTarifa() {
        saldo -= tarifa;
        System.out.println("Tarifa mensal de " + tarifa + " cobrada. Saldo atual: " + saldo);
    }
}
