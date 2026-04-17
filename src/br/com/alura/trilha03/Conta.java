package br.com.alura.trilha03;

public class Conta {
    private String titular;
    private double saldo;

    public void sacar (double valor) {
        if (valor <= 0){
            System.out.println("O maior deve ser maior que do zero!");
        } else if (saldo >= valor) {
            saldo -= valor;
            System.out.println("Saque realizado com sucesso. Saldo atual: " + saldo);
        }else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public void depositar(double valor) {
        if(valor > 0) {
            saldo += valor;
            System.out.println("Deposito realizado com sucesso" + saldo);
        }else {
            System.out.println("Valor deve ser maior que zero");
        }
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

}
