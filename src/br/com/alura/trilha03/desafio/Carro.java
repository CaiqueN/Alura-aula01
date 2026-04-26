package br.com.alura.trilha03.desafio;

public class Carro {
    private String modelo;
    private double precoAno1;
    private double precoAno2;
    private double precoAno3;

    private double calcularMenorPreco() {
        double menorPreco = precoAno1;
        if (precoAno2 < menorPreco){
            menorPreco = precoAno2;
        }

        if (precoAno3 < menorPreco) {
            menorPreco = precoAno3;
        }

        return menorPreco;

    }

    private double  calcularMaiorPreco() {
        double maiorPreco = precoAno1;
        if(precoAno2 > maiorPreco){
            maiorPreco = precoAno2;
        }

        if (precoAno3 > maiorPreco){
            maiorPreco = precoAno3;
        }

        return maiorPreco;
    }


    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPreco1() {
        return precoAno1;
    }

    public void setPreco1(double preco1) {
        this.precoAno1 = preco1;
    }

    public double getPreco2() {
        return precoAno2;
    }

    public void setPreco2(double preco2) {
        this.precoAno2 = preco2;
    }

    public double getPreco3() {
        return precoAno3;
    }

    public void setPreco3(double preco3) {
        this.precoAno3 = preco3;
    }

    public double getMenorPreco() {
        return calcularMenorPreco();
    }

    public double getMaiorPreco() {
        return calcularMaiorPreco();
    }
}
