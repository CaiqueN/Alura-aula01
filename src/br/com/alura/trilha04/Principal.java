package br.com.alura.trilha04;

import br.com.alura.trilha02.screenmatch.aula01.modelo.Filme;
import br.com.alura.trilha03.Serie;

public class Principal {

    public static void main(String[] args) {

        Filme meuFilme = new Filme();
        meuFilme.setNome("O Poderoso Chefão");
        meuFilme.setAnoDeLancamento(1972);
        meuFilme.setDuracaoMinutos(175);
        meuFilme.avaliacao(8);
        meuFilme.avaliacao(10);
        meuFilme.avaliacao(5);

        Filme outroFilme = new Filme();
        outroFilme.setNome("Dragon Ball Super Broly");
        outroFilme.setAnoDeLancamento(2019);
        outroFilme.setDuracaoMinutos(100);
        outroFilme.avaliacao(7);
        outroFilme.avaliacao(9);

        Serie lost = new Serie();
        lost.setNome("Lost");
        lost.setAnoDeLancamento(2004);
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
