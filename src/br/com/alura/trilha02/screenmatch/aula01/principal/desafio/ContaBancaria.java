package br.com.alura.trilha02.screenmatch.aula01.principal.desafio;

public class ContaBancaria {
    private int numeroConta;
    private int saldo;
    public String titular;
    public int depositar;

    public int getNumeroConta() {
        return numeroConta;
    }

    public void depositar(int valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito realizado com sucesso");
        } else {
            System.out.println("Valor inválido");
        }
    }

    public int getDepositar(){
        return depositar;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public int getSaldo() {
        return saldo;
    }

    private void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

}
