package br.com.alura.trilha04.desafiofinal.modelo;

public class Audio {
    private String Titulo;
    private double duracao;
    private int totalReproducoes;
    private double totalCurtidas;
    private int classificacao;

    public int getClassificacao() {
        return classificacao;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public double getDuracao() {
        return duracao;
    }

    public int getTotalReproducoes() {
        return totalReproducoes;
    }

    public double getTotalCurtidas() {
        return totalCurtidas;
    }

    public void curtir() {
        this.totalCurtidas++;
    }

    public void reproduz() {
        this.totalReproducoes++;
    }
}
