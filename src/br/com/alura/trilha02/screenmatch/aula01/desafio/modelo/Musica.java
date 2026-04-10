package br.com.alura.trilha02.screenmatch.aula01.desafio.modelo;

public class Musica {
    public String titulo;
    public String artista;
    public int anoDeLancamento;
    double somaAvaliacao;
    int numAvaliacoes;

    public void exibirFichaTecnica() {
        System.out.println("Titulo da musica" + titulo);
        System.out.println("Artista" + artista);
        System.out.println("Ano de lançamento" + anoDeLancamento);


    }

    public void avalia(double nota) {
        somaAvaliacao += nota;
        numAvaliacoes ++;
    }

    public double media() {
      return   somaAvaliacao / numAvaliacoes;}
}
