package br.com.alura.trilha02.screenmatch.aula01.principal;

import br.com.alura.trilha02.screenmatch.aula01.modelo.Filme;
import br.com.alura.trilha03.Serie;

import java.util.ArrayList;


public class PrincipalFilme {
    public static void executar() {

        //Assim que instancia um objeto
        Filme filme = new Filme(2019,"Dragon ball Broly");
        filme.setDuracaoMinutos(180);
        filme.setSomaAvaliacao(10);
        filme.setTotalDeAvaliacao(1);

        filme.exibeFichaTecnica();
        filme.avaliacao(8);
        filme.avaliacao(10);
        filme.avaliacao(5);

        System.out.println("Total de avaliações: "+ filme.getTotalDeAvaliacao());
        System.out.println("Nome do filme: "+ filme.getNome());
        System.out.println(filme.media());

        System.out.println(filme.media());

        Serie lost = new Serie(2000, "Lost");
        lost.exibeFichaTecnica();
        lost.setTemporadas(10);
        lost.setEpisodiosPorTemporada(10);
        lost.setMinutosPorEpisodio(50);
        System.out.println("Duração do filme: " + lost.getDuracaoEmMinutos());

        var filmeDoCaique = new Filme(2000,"Senhor dos anéis");
        filmeDoCaique.setDuracaoMinutos(200);
        filmeDoCaique.avaliacao(10);

        ArrayList<Filme> listaDeFilmes = new ArrayList<>();
        listaDeFilmes.add(filme);
        listaDeFilmes.add(filmeDoCaique);
        System.out.println("Tamanho da lista de filmes :" + listaDeFilmes.size());
        System.out.println("Primeiro filme: " + listaDeFilmes.get(0).getNome());
        System.out.println("Segundo filme: " + listaDeFilmes.get(1).getNome());
        System.out.println(listaDeFilmes);
        System.out.println("Tostring filme: " + listaDeFilmes.get(0).toString());
    }

}
