package java_trilha_02.aula01.desafio;

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
