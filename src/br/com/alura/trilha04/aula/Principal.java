package br.com.alura.trilha04.aula;

import br.com.alura.trilha02.screenmatch.aula01.modelo.Filme;
import br.com.alura.trilha03.Serie;

public class Principal {

    public static void main(String[] args) {

        Filme meuFilme = new Filme(2000, "O Poderoso Chefão");
        meuFilme.setDuracaoMinutos(175);
        meuFilme.avaliacao(8);
        meuFilme.avaliacao(10);
        meuFilme.avaliacao(5);

        Filme outroFilme = new Filme(2019, "Dragon Ball Super Broly");
        outroFilme.setDuracaoMinutos(100);
        outroFilme.avaliacao(7);
        outroFilme.avaliacao(9);

        Serie lost = new Serie(2001, "Lost");
        lost.setTemporadas(6);
        lost.setEpisodiosPorTemporada(24);
        lost.setMinutosPorEpisodio(42);

        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(meuFilme);
        calculadora.inclui(outroFilme);
        calculadora.inclui(lost);
        System.out.println(calculadora.getTempoTotal());

        FiltroRecomendacao filtro = new FiltroRecomendacao();
        filtro.filtra(meuFilme);

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setSerie(lost);
        episodio.setTotalVisualizacoes(300);
        filtro.filtra(episodio);
    }
}
