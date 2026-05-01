package br.com.alura.trilha04.desafiofinal.servico;

import br.com.alura.trilha04.desafiofinal.modelo.Audio;

public class Favoritas {

    public void inclua(Audio audio) {
        if (audio.getClassificacao() >= 9) {
            System.out.println(audio.getTitulo() + " É um sucesso absoluto nos apps de musicas");
        } else {
            System.out.println(audio.getTitulo() + " Esta na lista para ouvir depois");
        }
    }
}
