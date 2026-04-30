package br.com.alura.trilha04.desafio;

public class Livro extends Produto implements Calculavel {
    private String autor;

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public double calcularPrecoFinal() {
        return precoUnitario * 0.9;
    }
}
