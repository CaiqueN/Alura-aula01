package br.com.alura.trilha02.screenmatch.aula01.principal;

import br.com.alura.trilha02.screenmatch.aula01.modelo.Filme;
import br.com.alura.trilha03.Serie;
import br.com.alura.trilha03.Titulo;

import java.util.ArrayList;

public class PrincipalComListas {
    public static void executar(){
        Filme meuFilme = new Filme(2000, "O Poderoso Chefão");
        Serie lost = new Serie(2001, "Lost");

        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(meuFilme);
        lista.add(lost);

        for (Titulo item : lista) {
            System.out.println(item.getNome());
            if (item instanceof Filme) {
                Filme filme = (Filme) item;
                System.out.println("Classificação" + filme.getClassificacao());
            }
        }
    }
}
