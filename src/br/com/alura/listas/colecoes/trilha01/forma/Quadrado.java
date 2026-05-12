package br.com.alura.listas.colecoes.trilha01.forma;

public class Quadrado implements Forma {
    double lado;

    @Override
    public double calcularArea() {
        return lado * lado;
    }
}
