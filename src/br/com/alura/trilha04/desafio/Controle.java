package br.com.alura.trilha04.desafio;

public class Controle extends Produto implements Calculavel {
    @Override
    public double calcularPrecoFinal() {
        return precoUnitario;
    }
}
