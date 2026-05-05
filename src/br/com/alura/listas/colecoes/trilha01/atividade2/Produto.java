package br.com.alura.listas.colecoes.trilha01.atividade2;

public class Produto {
    private String jogo;
    private double preco;
    private int quantidade;

    public Produto(String jogo, double preco, int quantidade) {
        this.jogo = jogo;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getJogo() {
        return jogo;
    }

    public void setJogo(String jogo) {
        this.jogo = jogo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Produto [nome=" + jogo + ", preco=" + preco + ", quantidade=" + quantidade + "]";
    }
}
