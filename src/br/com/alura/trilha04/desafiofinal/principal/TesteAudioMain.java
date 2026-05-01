package br.com.alura.trilha04.desafiofinal.principal;

import br.com.alura.trilha04.desafiofinal.modelo.Music;
import br.com.alura.trilha04.desafiofinal.modelo.Podcast;
import br.com.alura.trilha04.desafiofinal.servico.Favoritas;

public class TesteAudioMain {
    public static void executar() {

        Music musica = new Music();
        musica.setTitulo("Never Too Late:");
        musica.setCantor("Caique");

        for (int i = 0; i < 100; i++) {
            musica.reproduz();
            System.out.println(musica.getClassificacao() + " Classificação da musica " + musica.getTitulo());
        }

        for (int j = 0; j < 100; j++) {
            musica.curtir();
        }

        Podcast podcast = new Podcast();
        podcast.setTitulo("flow:");
        podcast.setApresentador("Igor");

        for (int i = 0; i < 100; i++) {
            podcast.reproduz();
        }

        for (int j = 0; j < 100; j++) {
            podcast.curtir();
        }

        Favoritas favoritas = new Favoritas();
        favoritas.inclua(podcast);
        favoritas.inclua(musica);
    }
}
