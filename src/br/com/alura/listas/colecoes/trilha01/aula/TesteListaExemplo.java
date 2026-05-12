package br.com.alura.listas.colecoes.trilha01.aula;

import br.com.alura.trilha02.screenmatch.aula01.modelo.Filme;

public class TesteListaExemplo {
    public static void executar() {
        int[] numeros = new int[3];
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = i + 1;
        }

        Filme[] filmes = new Filme[2];
        filmes[0] = new Filme(2019, "Dragon Ball");
        filmes[0].setDuracaoMinutos(60);

        filmes[1] = new Filme(2002, "Senhor dos Anéis");
        filmes[1].setDuracaoMinutos(200);

        System.out.println("Primeiro filme: " + filmes[0].getNome());
        System.out.println("Segundo filme: " + filmes[1].getNome());
    }
}
