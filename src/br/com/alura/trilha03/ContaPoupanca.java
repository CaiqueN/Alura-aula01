package br.com.alura.trilha03;

public class ContaPoupanca extends Conta{
    private double taxaJuros;

    public void calcularJuros(){
        double juros = this.getSaldo() * taxaJuros;
        System.out.println("Juros atual:" + juros);
    }

    public void sacar (double valor){
        double taxaSaque = 0.01;
        super.sacar(valor + taxaSaque);
    }

    public double getTaxaJuros() {
        return taxaJuros;
    }

    public void setTaxaJuros(double taxaJuros) {
        this.taxaJuros = taxaJuros;
    }

}
