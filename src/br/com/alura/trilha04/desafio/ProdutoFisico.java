package br.com.alura.trilha04.desafio;

public class ProdutoFisico extends Produto implements Calculavel {
    @Override
    public double calcularPrecoFinal() {
        return precoUnitario * 1.05;
    }
}
