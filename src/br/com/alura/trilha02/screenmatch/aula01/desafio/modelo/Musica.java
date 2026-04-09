package br.com.alura.trilha02.screenmatch.aula01.desafio.modelo;

public class Musica {
    String titulo;
    String artista;
    int anoDeLancamento;
    double somaAvaliacao;
    int numAvaliacoes;

    void exibirFichaTecnica() {
        System.out.println("Titulo da musica" + titulo);
        System.out.println("Artista" + artista);
        System.out.println("Ano de lançamento" + anoDeLancamento);


    }

    void avalia(double nota) {
        somaAvaliacao += nota;
        numAvaliacoes ++;
    }

    double media () {
      return   somaAvaliacao / numAvaliacoes;}
}
