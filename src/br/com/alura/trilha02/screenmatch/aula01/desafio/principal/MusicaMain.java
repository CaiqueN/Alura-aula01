package br.com.alura.trilha02.screenmatch.aula01.desafio.principal;

import br.com.alura.trilha02.screenmatch.aula01.desafio.modelo.Musica;

public class MusicaMain {
    public static void executar() {
        Musica lista = new Musica();
        lista.titulo = "Nome da musica";
        lista.artista = "Claude";
        lista.anoDeLancamento = 2026;

        lista.exibirFichaTecnica();

        lista.avalia(3.5);
        lista.avalia(7.6);
        lista.avalia(5.7);

        double mediaPega = lista.media();
        System.out.println("Media de avaliações " + mediaPega);
    }
}
