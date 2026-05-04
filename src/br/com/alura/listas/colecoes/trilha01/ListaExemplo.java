package br.com.alura.listas.colecoes.trilha01;

import br.com.alura.trilha02.screenmatch.aula01.modelo.Filme;


public class ListaExemplo {
   public static void executar(){
       int [] numeros = new int [3];

       for (int i = 0; i < numeros.length; i++){
           numeros [i] = i + 1;
       }

       Filme[] filmes = new Filme[2];

       Filme filme1 = new Filme();
       filme1.setNome("Dragon ball");
       filme1.setAnoDeLancamento(2019);
       filme1.setDuracaoMinutos(60);

       Filme filme2 = new Filme();
       filme2.setNome("Senhor dos Anéis");
       filme2.setAnoDeLancamento(2002);
       filme2.setDuracaoMinutos(200);

       filmes [0] = filme1;
       filmes [1] = filme2;

       System.out.println("Primeiro filme: " + filmes[0].getNome());
       System.out.println("Segundo filme: " + filmes[1].getNome());
   }
}
