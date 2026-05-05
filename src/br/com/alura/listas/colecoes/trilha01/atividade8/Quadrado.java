package br.com.alura.listas.colecoes.trilha01.atividade8;

public class Quadrado implements Forma {
    double lado;

    @Override
    public double calcularArea() {
        return lado * lado;
    }
}
