package br.com.alura.trilha02.screenmatch.aula01.principal;

import br.com.alura.trilha02.screenmatch.aula01.modelo.Filme;
import br.com.alura.trilha03.Serie;
import br.com.alura.trilha03.Titulo;

import java.util.*;

public class PrincipalComListas {
    public static void executar(){
        Filme meuFilme = new Filme(2000, "O Poderoso Chefão");
        Serie lost = new Serie(2001, "Lost");

        List<Titulo> lista = new ArrayList<>();
        lista.add(meuFilme);
        lista.add(lost);

        for (Titulo item : lista) {
            System.out.println(item.getNome());
            if (item instanceof Filme) {
                Filme filme = (Filme) item;
                System.out.println("Classificação" + filme.getClassificacao());
            }
        }

        ArrayList<String> buscaPorArtista = new ArrayList<>();
        buscaPorArtista.add("Adam Sandler");
        buscaPorArtista.add("Paulo");
        buscaPorArtista.add("Jacqueline");
        System.out.println(buscaPorArtista);

        Collections.sort(buscaPorArtista);
        System.out.println("Depois da ordenação");
        System.out.println(buscaPorArtista);
        System.out.println("Lista de titulos ordenados");
        Collections.sort(lista);
        System.out.println(lista);

        lista.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        System.out.println("Ordenado por ano de lançamento:");
        System.out.println(lista);

        lista.sort(Comparator.comparing(Titulo::getNome));
        System.out.println("Ordenado por nome:");
        System.out.println(lista);

    }
}
