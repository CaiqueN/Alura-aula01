package br.com.alura.trilha02.screenmatch.aula01.principal;

import br.com.alura.trilha02.screenmatch.aula01.modelo.Filme;

public class PrincipalFilme {
    public static void executar() {

        //Assim que instancia um objeto
        Filme filme = new Filme();
        filme.setNome("Dragon ball Broly");;
        filme.setAnoDeLancamento(2019);
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

    }

}
